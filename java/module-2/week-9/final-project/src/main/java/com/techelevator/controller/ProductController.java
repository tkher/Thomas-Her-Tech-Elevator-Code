package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    @RequestMapping(path = "?sku={product_sku}&name={product_name}", method = RequestMethod.GET)
    public List<Product> list(@PathVariable String sku, String name) {
        List<Product> foundProducts = productDao.getProduct();
//        try{
        if(sku == null || name == null){
            foundProducts.add(productDao.getProductById(1)); //***Not sure what to do if null
        } else {
            for (Product product : foundProducts) {
                if (product.getProductSku().equalsIgnoreCase(sku)) {
                    foundProducts.add(product);
                } else if (product.getName().equalsIgnoreCase(name)) {
                    foundProducts.add(product);
                }
            }
        }
            return foundProducts;
//        } catch ()
//        if (foundProducts == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
//        } else {
//            return foundProducts;
//        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product product (@PathVariable int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
        } else {
            return product;
        }
    }




}
