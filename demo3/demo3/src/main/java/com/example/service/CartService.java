package com.example.service;

import com.example.VO.CartVO;
import com.example.dao.CartDAO;
import com.example.pojo.Cart;

import java.util.List;

public class CartService {
    CartDAO cartDAO = new CartDAO();
    public boolean addCart(Cart cart){
        int flag = cartDAO.queryCart(cart);
        if(flag==0){
            return cartDAO.add(cart);
        }else {
            return cartDAO.upd(flag);
        }
    }
    public List<CartVO> listByUid(int uid){
        return cartDAO.listByUid(uid);
    }
    public boolean delCart(int cid){
        return cartDAO.del(cid);
    }
}
