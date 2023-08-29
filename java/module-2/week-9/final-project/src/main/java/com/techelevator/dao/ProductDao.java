package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

//The interface of products for productDao and dependency injection to Product Controller
public interface ProductDao {

    List<Product> product();

    List<Product> productsBySkuOrName(String sku, String name);

    Product getProductById(int id);

}
