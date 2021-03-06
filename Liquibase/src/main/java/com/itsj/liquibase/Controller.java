package com.itsj.liquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class Controller {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("person")
    public String createPerson(@RequestParam String name){
        personRepository.save(new Person(name,"6.7"));
        return personRepository.findbyName(name) + "save successfully";
    }

    @GetMapping("person")
    public List<Person> getAllThePeople(){
        return (List<Person>) personRepository.findAll();
    }
}