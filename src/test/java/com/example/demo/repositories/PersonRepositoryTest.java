package com.example.demo.repositories;


import com.example.demo.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("Test de guardado")
    public void testSave(){

        //Crea una instancia de Person con los datos que quieras (name, age).
       // Guarda la persona en el repositorio usando el método save().
        Person newPerson = new Person("Juan Ditto", 23);

        Person savedPerson = personRepository.save(newPerson);

        assertNotNull(savedPerson);

        //Busca la persona en el repositorio usando el método findById() y comprueba que no es nulo.
        //Imprime la persona por consola.
        Optional<Person> findById = personRepository.findById(savedPerson.getId());
        System.out.println(savedPerson);
        //Comprueba que el id de la persona no es nulo con una aserción.
        assertNotNull(savedPerson);

        //Comprueba que el nombre de la persona es "John Doe" con una aserción.
        //Comprueba que la edad de la persona es 30 con una aserción.
        // También puedes comprobar en mySQL que la persona se ha guardado correctamente en la tabla person.
        // Ten en cuenta que no lo estamos borrando así que te va a crear una fila en la tabla cada vez que
        // lo ejecutes.

        assertEquals("John Doe", newPerson.getName());
        assertEquals(30, newPerson.getAge());

    }

    @Test
    @DisplayName("Encuentro todas las personas")
    public void testFindAll(){
        //Crea una lista de personas con los datos que quieras (name, age).
        List<Person> person = new ArrayList<>();
        person.add(new Person("Juan Ditto", 23));
        person.add(new Person("Maria Pikachu", 25));
        person.add(new Person("Luis Charmander", 30));
        person.add(new Person("Ana Bulbasaur", 28));
        person.add(new Person("Carlos Squirtle", 35));
        //Guarda las personas en el repositorio usando el método saveAll().
        personRepository.saveAll(person);
        //Busca todas las personas en el repositorio usando el método findAll() y comprueba que no es nulo.
        List<Person> allPeople = personRepository.findAll();
        assertNotNull(allPeople);
        //Imprime la lista de personas por consola.
        for(Person people : allPeople){
            System.out.println(people);
        }
        //Comprueba que el nombre de la primera persona es "Ditto" (o el nombre que pusieras)
        // con una aserción.
        assertEquals("Juan Ditto", allPeople.getFirst().getName());


        //Comprueba que la edad de la primera persona es 30 con una aserción.
        assertEquals(30, allPeople.getFirst().getAge());
    }
    @Test
    @DisplayName("Borro personas")
    public void testDelete(){
        //Crea una instancia de Person con los datos que quieras (name, age).
        Person newPerson = new Person("Ana Bulbasaur", 28);
        //Guarda la persona en el repositorio usando el método save().
        Person savedPerson = personRepository.save(newPerson);
        //Busca la persona en el repositorio usando el método findById() y comprueba que no es nulo.
        Optional<Person> findById = personRepository.findById(savedPerson.getId());
        assertNotNull(savedPerson);
        //Borra la persona en el repositorio usando el método delete().
        personRepository.delete(newPerson);
        //Busca la persona en el repositorio usando el método findById() y comprueba que es nulo.
        Optional<Person> deletedPerson = personRepository.findById(newPerson.getId());
        //Imprime la persona por consola.
        System.out.println(deletedPerson);
        //Comprueba que el id de la persona es nulo con una aserción.
        assertNull(deletedPerson);
    }

    @Test
    @DisplayName("Actualizo informacion")
    public void testUpdate(){
        //Crea una instancia de Person con los datos que quieras (name, age).
        Person newPerson = new Person("Ana Bulbasaur", 28);
        //Guarda la persona en el repositorio usando el método save().
        Person savedPerson = personRepository.save(newPerson);
        //Busca la persona en el repositorio usando el método findById() y comprueba que no es nulo.
        Optional<Person> findById = personRepository.findById(savedPerson.getId());
        assertNotNull(savedPerson);
        //Cambia el nombre y la edad de la persona.
        newPerson.setName("Anita la Muchachita");
        //Guarda la persona en el repositorio usando el método save().
        personRepository.save(newPerson);
        //Busca la persona en el repositorio usando el método findById() y comprueba que no es nulo.
        Optional<Person> findById2 = personRepository.findById(savedPerson.getId());
        assertNotNull(savedPerson);
        //Imprime la persona por consola.
        System.out.println(findById2);
        //Comprueba que el id de la persona no es nulo con una aserción.
        assertNotNull(savedPerson);
        //Comprueba que el nombre de la persona es "Nuevo nombre" (o el nombre que pusieras) con una aserción.
        assertEquals("Anita la Muchachita", savedPerson.getName());
        //Comprueba que la edad de la persona es 30 (o lo que pusieras en la nueva edad) con una aserción.
        assertEquals(28, savedPerson.getAge());

    }
}
