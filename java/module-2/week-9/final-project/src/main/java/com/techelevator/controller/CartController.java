package com.techelevator.controller;

import com.techelevator.Service.ShoppingCartService;
import com.techelevator.dao.CartDao;
import com.techelevator.model.Cart;
import com.techelevator.model.ShoppingCart;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/Cart")
public class CartController {


    private CartDao cartDao;

    private ShoppingCart shoppingCart = new ShoppingCart();

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }



    //Methods
    //1. View Cart
    public ShoppingCart viewCart() {
        return null;
    }




}
