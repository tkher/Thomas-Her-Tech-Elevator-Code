package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//Test in postman the api endpoints.

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    //Why do we have to set the constructor to implement jdbctemplate? is it to so each method has to implement jdbc client?
    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<Product> products = new ArrayList<>();

    //    1. Get a list of all products for sale
    @Override
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return products;
    }

    //    2. Search for a list of products by SKU or Name
    //2.1 Get product by SKU
    public List<Product> getProductBySku(String sku) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_sku = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,sku);
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return products;
    }


    //2.2 Get product by Name
    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return products;
    }



    //    3. Search for product by ID and return product detail
    @Override
    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                product = mapRowToProduct(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to Database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return product;
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setProductId(results.getInt("product_id"));
        product.setProductSku(results.getString("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));
        return product;

    }

}
