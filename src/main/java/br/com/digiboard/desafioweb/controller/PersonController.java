package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.model.Person;
import br.com.digiboard.desafioweb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/usuarios")

public class PersonController {
//    @Autowired
//    private PersonRepository personRepository;
//
//
//    @GetMapping
//    public List<Person> list(Model model) {
//        return personRepository.findAll();
//    }
//
//    @PostMapping
//    public void add(@RequestBody Person user) {
//        personRepository.save(user);
//    }
//
//    @PutMapping
//    public void edit(@RequestBody Person user){
//        personRepository.save(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        personRepository.deleteById(id);
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Person> ler(@PathVariable Long id){
//        return personRepository.findById(id);
//    }



}
