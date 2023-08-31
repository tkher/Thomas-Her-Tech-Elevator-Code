package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Cart;
import com.techelevator.model.ShoppingCart;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//may require a CartService and TaxService, instead of putting into a dao
//No dependency injections on Dao layer
@Component
public class JdbcCartDao implements CartDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    private List<Cart> inCart = new ArrayList<>(); //do i really need a list of carts?

    //1. Get -  View Shopping Cart: List of products, qty, and prices
        //Additional Details Req: Subtotal cost, Tax amount, Cart Total: Sub + Tax

    public List<ShoppingCart> getCartProducts() {
        List<ShoppingCart> allCartItems = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM product INNER JOIN cart_item " +
                "ON product.product_id = cart_item.product_id;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                allCartItems.add(mapRowToCartProduct(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return allCartItems;
    }

    @Override
    public List<Cart> getCart() {
        List<Cart> cart = new ArrayList<>();
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

    private ShoppingCart mapRowToCartProduct(SqlRowSet results) {
        ShoppingCart cartProduct = new ShoppingCart();
        cartProduct.setProductId(results.getInt("product_id"));
        cartProduct.setProductSku(results.getString("product_sku"));
        cartProduct.setName(results.getString("name"));
        cartProduct.setDescription(results.getString("description"));
        cartProduct.setPrice(results.getBigDecimal("price"));
        cartProduct.setImageName(results.getString("image_name"));
        cartProduct.setCartItemId(results.getInt("cart_item_id"));
        cartProduct.setUserId(results.getInt("user_id"));
        cartProduct.setQuantity(results.getInt("quantity"));

        return cartProduct;
    }

}
