package com.example.service;

import com.example.pojo.Cart;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CartServiceTest {
    CartService cartService = new CartService();

    @Test
    public void addCart() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setMid(1);
        boolean b = cartService.addCart(cart);
        assertThat(b,is(true));
    }
}