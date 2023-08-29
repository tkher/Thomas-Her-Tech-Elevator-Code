package com.techelevator.dao;

import com.techelevator.model.Cart;
import com.techelevator.model.Product;

import java.util.List;

public interface CartDao {

    List<Cart> getCart();

    Cart addToCart(int id);

    Cart removeFromCart(int id);

    Cart clearCart();



}
