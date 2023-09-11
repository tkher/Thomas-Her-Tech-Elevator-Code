package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while(results.next()) {
                books.add(mapRowToBook(results));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return books;
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;

        String sql = "SELECT * FROM book " +
                    "WHERE book_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,bookId);

            if(results.next()) {
                book = mapRowToBook(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
            //throw new UnsupportedOperationException("Not implemented yet");
        }
        return book;
    }

    @Override
    public Book updateBookRating(int bookId, BigDecimal newRating) {
        Book book = new Book();
        book.setStarRating(newRating);

        Book updatedBook = null;


        String sql = "UPDATE book SET star_rating = ? " +
                "WHERE book_id = ?;";

        try{
            int numberOfRows = jdbcTemplate.update(sql, book.getStarRating());

            if(numberOfRows == 0) {
                throw new DaoException("Zero rows affected, invalid ID");
            } else {
                updatedBook = getBookById(book.getBookId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            //throw new UnsupportedOperationException("Not implemented yet");
            throw new DaoException("Data integrity violation", e);
        }
        return updatedBook;
    }


    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();
        book.setBookId(results.getInt("book_id"));
        book.setBookTitle(results.getString("book_title"));
        book.setStarRating(results.getBigDecimal("star_rating"));
        book.setOutOfPrint(results.getBoolean("out_of_print"));
        book.setForewordBy((Integer) results.getObject("foreword_by"));
        book.setPublisherId(results.getInt("publisher_id"));
        book.setPublishedDate(results.getDate("published_date").toLocalDate());
        return book;
    }
}
