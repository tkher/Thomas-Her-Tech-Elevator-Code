package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    //Dependency Injection
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    //Does not need path as using base path
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return productDao.getProduct();
    }

    //path is HTTP request - if running on a service class
    //Anything after the question mark is a parameter (SQL)- like in a method - exceptable to have the list endpoint be the path.
    //The ? does not have to be hardcoded either.
    //path = "?sku={product_sku}&name={product_name}"
    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> listBySkuOrName(@RequestParam String sku, @RequestParam String name) {
        List<Product> foundProducts = new ArrayList<>();
        //if sku or name is null then return all products
        if (sku == null || name == null) {
            foundProducts = productDao.getProduct();
            return foundProducts;

        } else {
            List<Product> searchProducts = productDao.getProductBySku(sku);
            for (Product product : searchProducts) {
                    foundProducts.add(product);
                }
            List<Product> searchProductName = productDao.getProductByName(sku);
            for (Product product : searchProductName) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product product(@PathVariable int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
        } else {
            return product;
        }
    }


}
