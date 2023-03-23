package br.com.digiboard.desafioweb.beans;

import br.com.digiboard.desafioweb.controller.PersonService;
import br.com.digiboard.desafioweb.model.Address;
import br.com.digiboard.desafioweb.model.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Named(value = "peopleBean") //dinindo nome do bean
@Getter
@Setter
@ViewScoped
public class PersonBean implements Serializable {

    private List<Person> people;
    private Person person = new Person();
    private Person personUpdate= new Person();
    private Address address = new Address();
    List<Person> filteredPeople = new ArrayList<>();
    private String searchString;
    private PersonService personService;

    @Autowired
    public PersonBean(PersonService personService){
        this.personService=personService;

    }


    // método anotado com @PostConstruct para listar todas as pessoas ao carregar a página lista.xhtml
    //verifica se a barra esta em branco e pesquisa todos ou verifica a pesquisa pela string digitada
    @PostConstruct

    public List<Person> listAll() {

        if(searchString == null || searchString.isBlank() || searchString.equals("")) {
            people =  personService.getAllPersons();
            return people;
        } else {
            filteredPeople = personService.getPersonsBySearchString(searchString);
            return filteredPeople;
        }
    }

    // atualizar pessoa selecionada no banco de dados
    public void updatePerson(Person personUpdate){

        personService.update(personUpdate);
    }

    //EXCLUSAO DE PESSOA NO BANCO DE DADOS
    public void deletePerson(Long id) {
        Optional<Person> person = personService.findById(id);
        if (person != null) {
            personService.delete(person.get().getId());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath() + "/lista.xhtml";
        try {
            context.getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createPerson() {
        try {
            // cria uma nova pessoa com os dados informados no formulário
            Person newPerson = new Person();
            newPerson.setFirstName(person.getFirstName());
            newPerson.setLastName(person.getLastName());
            newPerson.setDateBirth(person.getDateBirth());

            // instancia um novo objeto Address
            Address newAddress = new Address();
            newAddress.setStreet(address.getStreet());
            newAddress.setNumberHouse(address.getNumberHouse());
            newAddress.setNeighborhood(address.getNeighborhood());
            newAddress.setCity(address.getCity());
            newAddress.setState(address.getState());
            newAddress.setCountry(address.getCountry());
            newPerson.setAddress(newAddress);


            // salva a nova pessoa no banco
            personService.add(newPerson);


            // limpa os dados
            person = new Person();


            // retorna a página lista.xhtml após salvar a nova pessoa
            return "index.xhtml?faces-redirect=true";

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar pessoa", null));
            return null;
        }
    }






    public String getFormattedDate(LocalDate date) {
        if (date == null) {
            return "";
        }
        Date utilDate = java.sql.Date.valueOf(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    public void filterPeople() {

        setPeople(personService.getPersonsBySearchString(searchString));
    }






}
