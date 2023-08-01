package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
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
    List<Customer> customerList = new ArrayList<>();

    String sql = "SELECT * " +
            "FROM customer " +
            "ORDER BY customer_id;";

    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

    try {
        while (results.next()) {
            customerList.add(mapValueToRowSet(results));
        }
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Cannot connect to Datebase", e);
    } catch (DataIntegrityViolationException e) {
        throw new DaoException("Data Violation", e);
    }
    return customerList;
    }

    public Customer createCustomer(Customer newCustomer) {
    Customer customer = new Customer();

    String sql = "INTO INTO customer (name, street_address1, street_address2, city, state, zip_code " +
            "VALUES (?,?,?,?,?,?) RETURNING customer_id;";

    try {
        int customerId= jdbcTemplate.queryForObject(sql, int.class, customer.getName(), customer.getStreetAddress1(), customer.getStreetAddress2(),
                customer.getCity(), customer.getState(), customer.getZipCode());

        customer = getCustomerById(customerId);
    } catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("Cannot connect to Datebase", e);
    } catch (DataIntegrityViolationException e) {
        throw new DaoException("Data Violation", e);
    }
    return customer;
    }

    public Customer updateCustomer (Customer updatedCustomer) {
        Customer customer = null;

        String sql = "UPDATE customer SET name = ?, street_address1 = ?, street_address2 = ?, city = ?, state = ?, zip_code = ? " +
                "WHERE customer_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, customer.getName(), customer.getStreetAddress1(), customer.getStreetAddress2(),
                    customer.getCity(), customer.getState(), customer.getZipCode());

            if (numberOfRows == 0) {
                throw new DaoException("Id not found");
            } else {
                customer = getCustomerById(customer.getCustomerId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to Datebase", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Violation", e);
        }
        return customer;
    }
}
