package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

public Customer mapValueToCustomer (SqlRowSet results);
    Customer customer = new Customer();
    customer.setCustomerId(results.getInt("customer_id"));


    @Override

    public Customer getCustomerById(int customerId) {

        return null;
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
