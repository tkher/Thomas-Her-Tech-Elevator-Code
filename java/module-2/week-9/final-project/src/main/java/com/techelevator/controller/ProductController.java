package com.techelevator.controller;

import com.techelevator.model.Product;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

//    1. Get a list of all products for sale
    public List<Product> product () {
        return products;
    }

//    2. Search for a list of products by SKU or Name
    public List<Product> productsBySkuOrName(@PathVariable String sKU, String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductSku() == sKU) {
                foundProducts.add(product);
            } else if (product.getName() == name) {
                foundProducts.add(product);
            }
        }
        return foundProducts;

    }


//    3. Search for product by ID and return product detail
    public Product getProductById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }


}
