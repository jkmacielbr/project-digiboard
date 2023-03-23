package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.model.Person;
import br.com.digiboard.desafioweb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person add(Person person) {
        return this.personRepository.save(person);

    }
    public void update(Person person){
        personRepository.save(person);

 }


    public Optional<Person> findById(Long id) {
        return this.personRepository.findById(id);
    }

    public Optional<Person> delete(Long id) {
        Optional<Person> delete = findById(id);
        this.personRepository.deleteById(id);
        return delete;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getPersonsBySearchString(String searchString) {
        return personRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByFirstNameAscLastNameAsc(searchString,searchString);
    }
}
