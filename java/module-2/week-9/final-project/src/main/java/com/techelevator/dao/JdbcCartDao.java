package com.techelevator.dao;

import com.techelevator.model.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//may require a CartService and TaxService, instead of putting into a dao
//No dependency injections on Dao layer
@Component
public class JdbcCartDao implements CartDao{

    private List<Cart> inCart = new ArrayList<>();

    //1. Get -  View Shopping Cart: List of products, qty, and prices
        //Additional Details Req: Subtotal cost, Tax amount, Cart Total: Sub + Tax
    @Override
    public List<Cart> getCart() {
        return null;
    }



    //2. Post - Add product to Cart
    @Override
    public Cart addToCart(int id) {
        return null;
    }




    //3. Delete - Delete specific item from Cart by ID - entire quantity
    @Override
    public Cart removeFromCart(int id) {
        return null;
    }



    //4. Delete - Delete all items in cart
    @Override
    public Cart clearCart() {
        return null;
    }


}
