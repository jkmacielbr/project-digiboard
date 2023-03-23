package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.beans.PersonBean;
import br.com.digiboard.desafioweb.model.Address;
import br.com.digiboard.desafioweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class PersonRestController {
//    @Autowired
//    private PersonService personService;
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private PersonBean personBean;
//
//    @PostMapping(
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE}
//    )
//
//    public ResponseEntity<Person> saveUser(@RequestBody Person user) {
//        Address address = user.getAddress();
//        addressService.add(address);
//        personService.add(user);
//        personBean.listAll();
//        return ResponseEntity.ok(user);
//
//    }
//
//    //LIST
//    @GetMapping
//    public Iterable<Person> list() {
//        return this.personService.list();
//    }
//
//    //FIND BY ID
//    @GetMapping(value = "{id}")
//    public Optional<Person> findyId(@PathVariable Long id) {
//        return this.personService.findById(id);
//    }
//
//    //ADD USER
//    @PostMapping
//    public void save(@RequestBody Person user) {
//
//        addressService.add(user.getAddress());
//        personService.add(user);
//
//    }
//
//    // UPDATE USER
//    @PutMapping
//    public Person update(@RequestBody Person user) {
//        return personService.add(user);
//    }
//
//    // DELETE USER
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        personService.delete(id);
//
//    }


}
