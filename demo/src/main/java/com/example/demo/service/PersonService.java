package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired // auto wiring into this interface. Inject annotation also serve the same purpose, just that autowired is spring specific.
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) { // because we can have multiple implementation of PersonDao interface, Qualifier is the way to distinguish between them.
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
}
