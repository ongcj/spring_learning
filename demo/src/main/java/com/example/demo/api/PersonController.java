package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController // this is a RestController class, where we can have methods and expose some endpoints that client can consume.
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping // tell spring that this method will be used as a POST request.
    public void addPerson(@RequestBody Person person) { // take the request body and put inside Person
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    // set the variable after the forward slash and retrieve in method later.
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }

}
