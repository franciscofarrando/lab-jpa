package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/person")
    /* public List<Person> findAll(){
        return personRepository.findAll();
    }
    */

   public String save(){
        return "hola";
    }

}
