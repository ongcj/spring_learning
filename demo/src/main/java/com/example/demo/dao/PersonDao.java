package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    // insert a person into actual database. mock a database using a list.
    // insert a person with a given id
    int insertPerson(UUID id, Person persion);
    // insert a person without an id
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // return a list of person
    List<Person> selectAllPeople();
}
