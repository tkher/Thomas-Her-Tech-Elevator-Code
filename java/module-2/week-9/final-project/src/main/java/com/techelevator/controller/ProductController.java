package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductDao productDao;

    //Dependency Injection
    public ProductController(ProductDao productDao) {
    this.productDao = productDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> list() {
        return productDao.product();
    }

    @RequestMapping(path = "?sku={product_sku}&name={product_name}", method = RequestMethod.GET)
    public List<Product> productsBySkuOrName(@PathVariable String sku, String name) {
        List<Product> foundProducts = productDao.productsBySkuOrName(sku, name);
        if (foundProducts == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
        } else {
            return foundProducts;
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product getById (@PathVariable int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
        } else {
            return product;
        }
    }




}
