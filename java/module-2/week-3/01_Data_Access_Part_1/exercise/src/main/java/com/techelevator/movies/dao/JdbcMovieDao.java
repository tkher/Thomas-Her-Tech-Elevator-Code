package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Movie mapToRowSet(SqlRowSet result) {
        Movie movie = new Movie();
        movie.setId(result.getInt("movie_id"));
        movie.setTitle(result.getString("title"));
        movie.setOverview(result.getString("overview"));
        movie.setTagline(result.getString("tagline"));
        movie.setPosterPath(result.getString("poster_path"));
        movie.setHomePage(result.getString("home_page"));
        movie.setReleaseDate(result.getDate("release_date").toLocalDate());
        movie.setLengthMinutes(result.getInt("length_minutes"));
        movie.setDirectorId(result.getInt("director_id"));
        movie.setCollectionId(result.getInt("collection_id"));
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * "+
                "FROM movie; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            movies.add(mapToRowSet(result));
        }

        return movies;

    }

    @Override
    public Movie getMovieById(int id) {
        Movie movieById = null;

        String sql = "SELECT * " +
                "FROM movie " +
                "WHERE movie_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        while (result.next()) {
            movieById = mapToRowSet(result);
        }

        return movieById;
    }

//        return new Movie(-1, "Not implemented yet", "", "", "", "", null, 0, -1, -1);


    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> moviesByTitle = new ArrayList<>();

        if(useWildCard) {
            title = "%" + title + "%";
        }

        String sql = "SELECT * " +
                "FROM movie " +
                "WHERE title ILIKE ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, title);

        while (result.next()) {
            moviesByTitle.add(mapToRowSet(result));
        }

        return moviesByTitle;


    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
           int endYear, boolean useWildCard) {
        List<Movie> moviesByDirectorAndYear = new ArrayList<>();

        if(useWildCard) {
            directorName = "%" + directorName + "%";
        }

        String sqlStartDate = startYear + "/01/01";
        String sqlEndDate = endYear + " /12/31";

        String sql = "SELECT * " +
                "FROM movie " +
                "JOIN person ON movie.director_id = person.person_id " +
                "WHERE person.person_name ILIKE ? AND release_date BETWEEN '" + sqlStartDate + "' AND '" + sqlEndDate + "' " +
                "ORDER BY release_date;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, directorName);

        while (result.next()) {
            moviesByDirectorAndYear.add(mapToRowSet(result));
        }

        return moviesByDirectorAndYear;
    }
}
