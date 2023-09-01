package com.techelevator.model;

import com.techelevator.Service.ShoppingCartService;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private List<CartProduct> cartProduct;
    private BigDecimal subtotal;
    private BigDecimal Tax;
    private BigDecimal cartTotal;

    public ShoppingCart() {

    }

    ShoppingCartService shoppingCartService = new ShoppingCartService();

    public ShoppingCart(CartProduct cartProduct, BigDecimal subtotal, BigDecimal tax, BigDecimal cartTotal, ShoppingCartService shoppingCartService) {
        this.cartProduct = (List<CartProduct>) cartProduct;
        this.subtotal = subtotal;
        Tax = tax;
        this.cartTotal = cartTotal;
        this.shoppingCartService = shoppingCartService;
    }

    public CartProduct getCartProduct() {
        return (CartProduct) cartProduct;
    }

    public void setCartProduct(CartProduct cartProduct) {
        this.cartProduct = (List<CartProduct>) cartProduct;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return Tax;
    }

    public void setTax(BigDecimal tax) {
        Tax = tax;
    }

    public BigDecimal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(BigDecimal cartTotal) {
        this.cartTotal = cartTotal;
    }

    public ShoppingCartService getShoppingCartService() {
        return shoppingCartService;
    }

    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartProduct=" + cartProduct +
                ", subtotal=" + subtotal +
                ", Tax=" + Tax +
                ", cartTotal=" + cartTotal +
                ", shoppingCartService=" + shoppingCartService +
                '}';
    }
}
