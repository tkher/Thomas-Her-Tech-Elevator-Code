package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

//The interface of products for productDao and dependency injection to Product Controller
public interface ProductDao {

    List<Product> getProduct();

//    List<Product> productsBySkuOrName(String sku, String name);
//    Do not need because both get methods just call the product()

    List<Product> getProductBySku(String sku);

    List<Product> getProductByName(String name);



    Product getProductById(int id);

}
