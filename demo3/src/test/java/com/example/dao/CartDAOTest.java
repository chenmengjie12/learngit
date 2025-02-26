package com.example.dao;

import com.example.VO.CartVO;
import com.example.pojo.Cart;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CartDAOTest {
    CartDAO cartDAO = new CartDAO();

    @Test
    public void listByUid() {
    }

    @Test
    public void add() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setMid(1);
        boolean add = cartDAO.add(cart);
        //assertThat 断言添加操作是否成功
        assertThat(add,is(true));

    }

    @Test
    public void del() {
    }

    @Test
    public void testListByUid() {
        List<CartVO> cartVOS = cartDAO.listByUid(2);
        cartVOS.forEach(System.out::println);
    }
}