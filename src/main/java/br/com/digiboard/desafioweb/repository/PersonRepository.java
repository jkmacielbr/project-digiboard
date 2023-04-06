package br.com.digiboard.desafioweb.repository;

import br.com.digiboard.desafioweb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByFirstNameAscLastNameAsc(String firstName, String lastName);

    List<Person> findAllByOrderByFirstNameAscLastNameAsc();
}
