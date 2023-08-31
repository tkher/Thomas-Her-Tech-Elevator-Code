package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Missing map to row sets, String sql,
//Test in postman the api endpoints.

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<Product> products = new ArrayList<>();

    //    1. Get a list of all products for sale
    @Override
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                products.add(mapRowToProduct(results));
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data violation", e);
        }
        return products;
    }

    //    2. Search for a list of products by SKU or Name
//    @Override
//    public List<Product> productsBySkuOrName(@PathVariable String sku, String name) {
//        List<Product> foundProducts = new ArrayList<>();
//        return foundProducts;
//
//    }


    //    3. Search for product by ID and return product detail
    @Override
    public Product getProductById(int id) {
        Product product = null;
        String sql = "";



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
