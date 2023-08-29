package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductDao {

    List<Product> product();

    List<Product> productsBySkuOrName(String sku, String name);

    Product getProductById(int id);

}
