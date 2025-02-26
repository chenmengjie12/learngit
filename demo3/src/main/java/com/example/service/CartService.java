package com.example.service;

import com.example.VO.CartVO;
import com.example.dao.CartDAO;
import com.example.pojo.Cart;

import java.util.List;

public class CartService {
    CartDAO cartDAO = new CartDAO();
    //添加购物车项
    public boolean addCart(Cart cart){
        //查询购物车中是否已有该项
        int flag = cartDAO.queryCart(cart);
        //如果不存在，则调用 cartDAO.add(cart) 添加新项
        if(flag==0){
            return cartDAO.add(cart);
        }else {
            //如果存在，则调用 cartDAO.upd(flag) 更新已有项
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
