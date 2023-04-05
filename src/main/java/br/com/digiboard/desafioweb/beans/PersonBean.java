package br.com.digiboard.desafioweb.beans;

import br.com.digiboard.desafioweb.controller.PersonService;
import br.com.digiboard.desafioweb.model.Address;
import br.com.digiboard.desafioweb.model.Person;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Named(value = "peopleBean") //dinindo nome do bean
@Getter
@Setter
@ViewScoped
public class PersonBean implements Serializable {

    private List<Person> personList;
    private Date now;
    private Person selectedUser;

    private Person person = new Person();
    private Address createAddress = new Address();
    private Address address = new Address();

    private String searchString;
    private PersonService personService;


    private String street;
    private Long numberHouse;

    private String neighborhood;

    private String city;

    private String state;

    private String  country;

    private String firstName;

    private String lastName;
    private LocalDate dateBirth;

    @Autowired
    public PersonBean(PersonService personService){
        this.personService = personService;
        selectedUser = new Person();

    }

    // método anotado com @PostConstruct para listar todas as pessoas ao carregar a página lista.xhtml
    //verifica se a barra esta em branco e pesquisa todos ou verifica a pesquisa pela string digitada


//    public void init() {
//        this.people = personService.getAllPersons();
//    }

    @PostConstruct
    public List<Person> listAll() {


        now = new Date();

        if(searchString == null || searchString.isBlank() || searchString.equals("")) {
            personList =  personService.getAllPersons();
            return personList;
        } else {

            return filterPeople();
        }
    }
    public void openNew(){
        this.selectedUser = new Person();
    }

    // atualizar pessoa selecionada no banco de dados
    public String updatePerson(){

        this.personService.update(this.selectedUser);

        return "lista.app?faces-redirect=true";
    }

    //EXCLUSAO DE PESSOA NO BANCO DE DADOS
    public void deletePerson() {
        Optional<Person> person = personService.findById(selectedUser.getId());
        if (person != null) {
            personService.delete(person.get().getId());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

//        FacesContext context = FacesContext.getCurrentInstance();
//        String url = context.getExternalContext().getRequestContextPath() + "/lista.app";
//        try {
//            context.getExternalContext().redirect(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    public String createPerson() {
//        try {
//            // cria uma nova pessoa com os dados informados no formulário
//            Person newPerson = new Person();
//            newPerson.setFirstName(person.getFirstName());
//            newPerson.setLastName(person.getLastName());
//            newPerson.setDateBirth(person.getDateBirth());
//
//            // instancia um novo objeto Address
//            Address newAddress = new Address();
//            newAddress.setStreet(address.getStreet());
//            newAddress.setNumberHouse(address.getNumberHouse());
//            newAddress.setNeighborhood(address.getNeighborhood());
//            newAddress.setCity(address.getCity());
//            newAddress.setState(address.getState());
//            newAddress.setCountry(address.getCountry());
//            newPerson.setAddress(newAddress);
//
//
//            // salva a nova pessoa no banco
//            personService.add(newPerson);
//
//
//            // limpa os dados
//            person = new Person();
//            address = new Address();
//
//
//
//            // retorna a página lista.xhtml após salvar a nova pessoa
//            return "index.app?faces-redirect=true";
//
//        } catch (Exception e) {
//
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar pessoa", null));
//            return null;
//        }
//    }


    public void createPerson() {
        Person newPerson = new Person();
        Address newAddress = new Address();
        try {
            // cria uma nova pessoa com os dados informados no formulário

            newPerson.setFirstName(this.firstName);
            newPerson.setLastName(this.lastName);
            newPerson.setDateBirth(this.dateBirth);

            // instancia um novo objeto Address
            newAddress.setStreet(this.street);
            newAddress.setNumberHouse(this.numberHouse);
            newAddress.setNeighborhood(this.neighborhood);
            newAddress.setCity(this.city);
            newAddress.setState(this.state);
            newAddress.setCountry(this.country);
            newPerson.setAddress(newAddress);


            // salva a nova pessoa no banco
            personService.add(newPerson);


            // limpa os dados
            person = new Person();



            emptyVariables();

            // retorna a página lista.xhtml após salvar a nova pessoa
//            return "index.app?faces-redirect=true";

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar pessoa", null));

        }
    }
    public void emptyVariables(){
        firstName="";
        lastName="";
        dateBirth=null;
        street="";
        numberHouse=null;
        neighborhood="";
        city="";
        state="";
        country = "";


    }


    public String getFormattedDate(LocalDate date) {
        if (date == null) {
            return "";
        }
        Date utilDate = java.sql.Date.valueOf(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    public List<Person> filterPeople() {

        return personList = personService.getPersonsBySearchString(searchString);
    }






}
