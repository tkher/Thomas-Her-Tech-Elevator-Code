package com.techelevator.dao;

import com.techelevator.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person getPersonById(int personId) {
        Person person = null;
        String sql = "SELECT person_id, first_name, last_name, birthdate, deathdate" +
                " FROM person WHERE person_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
        if (results.next()) {
            person = mapRowToPerson(results);
        }

        return person;
    }

    @Override
    public Person createPerson(Person newPerson) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int deletePersonById(int personId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Person mapRowToPerson(SqlRowSet results) {
        Person person = new Person();
        person.setPersonId(results.getInt("person_id"));
        person.setFirstName(results.getString("first_name"));
        person.setLastName(results.getString("last_name"));
        person.setBirthDate(results.getDate("birthdate").toLocalDate());
        if (results.getDate("deathdate") != null) {
            person.setDeathDate(results.getDate("deathdate").toLocalDate());
        }
        return person;
    }
}
