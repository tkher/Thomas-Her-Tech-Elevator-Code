package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Person;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
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

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
            if (results.next()) {
                person = mapRowToPerson(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return person;
    }

    @Override
    public Person createPerson(Person newPerson) {
        Person person = null;

        String sql = "INSERT INTO person (first_name, last_name, birthdate, deathdate) " +
                    "VALUES (?,?,?,?) " +
                    "RETURNING person_id;";

        try{
            int newPersonId = jdbcTemplate.queryForObject(sql,int.class, newPerson.getFirstName(), newPerson.getLastName(), newPerson.getBirthDate(), newPerson.getDeathDate());

            person = getPersonById(newPersonId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity violation", e);
        }
            return person;
    }

    @Override
    public int deletePersonById(int personId) {
        int numberOfRowsReturned = 0;

        String deleteScreenWriterSql = "DELETE FROM movie_screenwriter WHERE screenwriter_id = ?;";

        //String deleteMovieIds = "DELETE FROM movie WHERE director_id = ? OR music_by_id = ?;";

        String deletePersonSql = "DELETE FROM person WHERE person_id = ?;";

        try {
            jdbcTemplate.update(deleteScreenWriterSql,personId);

            //jdbcTemplate.update(deleteMovieIds,personId,personId);

            numberOfRowsReturned = jdbcTemplate.update(deletePersonSql,personId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity violation", e);
        }

        return numberOfRowsReturned;
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
