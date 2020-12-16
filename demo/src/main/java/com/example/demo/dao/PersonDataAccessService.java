package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired // Spring Boot knows how to create this class for us.
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person persion) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "select id, name from person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
