package com.techelevator.Service;

import com.techelevator.controller.CartController;
import com.techelevator.dao.JdbcCartDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.CartProduct;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {

    CartProduct cartProduct = new CartProduct();

    static JdbcTemplate jdbcTemplate = new JdbcTemplate();

    //1. Cart items and add to a list
    public static List<CartProduct> getAllCartProducts() {
        List<CartProduct> cartProducts = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM product INNER JOIN cart_item " +
                "ON product.product_id = cart_item.product_id " +
                "WHERE user_id = 1;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                cartProducts.add(mapRowToCartProduct(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to JDBC database", e);
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return cartProducts;
    }

    //2. get subtotal of all cart products
    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.valueOf(0.00);
        List <CartProduct> cartProducts = ShoppingCartService.getAllCartProducts();
        for (CartProduct cartProduct: cartProducts) {
            BigDecimal price = cartProduct.getPrice();
            subtotal = subtotal.add(price);
        }
        return subtotal;
    }

    //3. get tax - need a tax service

    //4. get Total - subtotal plus tax

    //get cartProducts, quantity * price, return as JSON object?
    public BigDecimal getSubTotal() {
        return null;
    }

    private static CartProduct mapRowToCartProduct(SqlRowSet results) {
        CartProduct cartProduct = new CartProduct();
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
