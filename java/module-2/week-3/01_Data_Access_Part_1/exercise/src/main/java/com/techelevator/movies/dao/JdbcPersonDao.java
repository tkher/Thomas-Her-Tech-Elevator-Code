package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Person mapToRowSet(SqlRowSet result) {
        Person person = new Person();
        person.setId(result.getInt("person_id"));
        person.setName(result.getString("person_name"));
        person.setBirthday(result.getDate("birthday").toLocalDate());
        person.setDeathDate(result.getDate("deathday").toLocalDate());
        if (result.wasNull()) {
            person.setDeathDate(null);
        }
        person.setBiography(result.getString("biography"));
        person.setProfilePath(result.getString("profile_path"));
        person.setHomePage(result.getString("home_page"));
        if (result.wasNull()) {
            person.setHomePage(null);
        }

        return person;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();

        String sql = "SELECT * "+
                "FROM person; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            persons.add(mapToRowSet(result));
        }

        return persons;

    }

    @Override
    public Person getPersonById(int id) {
        return new Person(-1, "Not implemented yet", null, null, "", "", "");
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        return null;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        return null;
    }
}
