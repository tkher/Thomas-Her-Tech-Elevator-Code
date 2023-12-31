package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Genre mapToRowSet(SqlRowSet result) {
        Genre genre = new Genre();
        genre.setId(result.getInt("genre_id"));
        genre.setName(result.getString("genre_name"));
//        if (result.wasNull()) {
//            genre.setId(null);
//        }
        return genre;

    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();

        String sql = "SELECT * "+
                "FROM genre; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            genres.add(mapToRowSet(result));
        }

        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        Genre genreById = null;

        String sql = "SELECT * " +
                "FROM genre " +
                "WHERE genre_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        while (result.next()) {
            genreById = mapToRowSet(result);
        }

        return genreById;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genreByName = new ArrayList<>();

        if(useWildCard) {
            name = "%" + name + "%";
        }

        String sql = "SELECT * " +
                "FROM genre " +
                "WHERE genre_name ILIKE ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);

        while (result.next()) {
            genreByName.add(mapToRowSet(result));
        }

        return genreByName;
    }
}
