package com.example.dao;

import com.example.VO.CartVO;
import com.example.pojo.Cart;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
* SELECT
m.mid,m.mname,m.pic,m.price,u.realname,u.id,c.num
from hcd_menu m
inner JOIN
hcd_cart c
on c.mid = m.mid
inner JOIN
userinfo u
on u.id = c.uid and u.id = 1*/
public class CartDAO {
    public List<CartVO> listByUid(int uid){
        List<CartVO> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConn();
        String sql = "SELECT\n" +
                "m.mid,m.mname,m.pic,m.price,u.realname,u.id,c.num,c.cid\n" +
                "from hcd_menu m\n" +
                "inner JOIN\n" +
                "hcd_cart c \n" +
                "on c.mid = m.mid\n" +
                "inner JOIN\n" +
                "userinfo u \n" +
                "on u.id = c.uid and u.id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,uid);
            ResultSet rst = pst.executeQuery();
            while (rst.next()){
                CartVO cartVO = new CartVO();
                cartVO.setMid(rst.getInt("mid"));
                cartVO.setMname(rst.getString("mname"));
                cartVO.setPic(rst.getString("pic"));
                cartVO.setPrice(rst.getDouble("price"));
                cartVO.setRealname(rst.getString("realname"));
                cartVO.setId(rst.getInt("id"));
                cartVO.setNum(rst.getInt("num"));
                cartVO.setCid(rst.getInt("cid"));
                list.add(cartVO);
            }
            JDBCUtil.close(rst,pst,conn);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean add(Cart cart){
        Connection conn = JDBCUtil.getConn();
        String sql = "insert into hcd_cart values(null,?,?,1)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,cart.getUid());
            pst.setInt(2,cart.getMid());
            int row = pst.executeUpdate();
            JDBCUtil.close(conn,pst);
            return row>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean del(int cid){
        Connection conn = JDBCUtil.getConn();
        String sql = "delete from hcd_cart where cid=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,cid);
            int row = pst.executeUpdate();
            JDBCUtil.close(conn,pst);
            return row>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean upd(int cid){
        Connection conn = JDBCUtil.getConn();
        String sql = "update hcd_cart set num = num +1 where cid=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            int row = pst.executeUpdate();
            JDBCUtil.close(conn,pst);
            return row>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int queryCart(Cart cart){
        Connection conn = JDBCUtil.getConn();
        String sql = "select cid,uid,mid from hcd_cart where  uid=? and mid=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,cart.getUid());
            pst.setInt(2,cart.getMid());
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                return rst.getInt("cid");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
