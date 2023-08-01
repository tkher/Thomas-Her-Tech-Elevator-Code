package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

private final JdbcTemplate jdbcTemplate;

public JdbcCustomerDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

public Customer mapValueToRowSet (SqlRowSet results) {
    Customer customer = new Customer();
    customer.setCustomerId(results.getInt("customer_id"));
    customer.setName(results.getString("name"));
    customer.setStreetAddress1(results.getString("street_address1"));
    customer.setStreetAddress2(results.getString("street_address2"));
    customer.setCity(results.getString("city"));
    customer.setState(results.getString("state"));
    customer.setZipCode(results.getString("zip_code"));
    return customer;
}

    @Override

    public Customer getCustomerById(int customerId) {
        Customer customer = null;

        String sql = "SELECT * " +
                "FROM customer " +
                "WHERE customer_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);

        try {
            if (results.next()) {
                customer = mapValueToRowSet(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to Datebase", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Violation", e);
        }
            return customer;
        }


    public List<Customer> getCustomers() {
        return null;
    }

    public Customer createCustomer(Customer newCustomer) {
        return null;

    }

    public Customer updateCustomer (Customer updatedCustomer) {
        return null;
    }
}
