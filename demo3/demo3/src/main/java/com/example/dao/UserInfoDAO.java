package com.example.dao;

import com.example.pojo.UserInfo;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {
    public UserInfo login(String loginname,String pass){
        Connection con = JDBCUtil.getConn();
        String sql = " select *from userinfo where loginname=? and pass=?";
        UserInfo userInfo=null;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,loginname);
            pst.setString(2,pass);
            ResultSet rst = pst.executeQuery();
            if (rst.next()){
                userInfo = new UserInfo();
                userInfo.setId(rst.getInt("id"));
                userInfo.setLoginname(rst.getString("loginname"));
                userInfo.setRealname(rst.getString("realname"));
                userInfo.setGender(rst.getString("gender"));
                userInfo.setIcon(rst.getString("icon"));
            }
            JDBCUtil.close(rst,pst,con);
            return userInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addUser(UserInfo userInfo) {
        //数据库链接 ctrl+alt+v
        Connection conn = JDBCUtil.getConn();
        //创建sql语句 ?占位符
        String sql = " insert into userinfo values(null,?,?,?,?,?)";
        //创建sql语句的对象
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            //获取用户的登录名，赋值给第一个占位符
            pst.setString(1, userInfo.getLoginname());
            pst.setString(2, userInfo.getRealname());
            pst.setString(3, userInfo.getPass());
            pst.setString(4, userInfo.getGender());
            pst.setString(5, userInfo.getIcon());
            int i = pst.executeUpdate();
            JDBCUtil.close(conn, pst);
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //执行sql
        //关闭连接
    }

    //物理删除
    public boolean delUser(Integer id) {
        Connection con = JDBCUtil.getConn();
        String sql = "delete from userinfo where id = ?";
        //创建执行sql的语句对象
        try {
            //alt+enter
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            //执行sql
            int row = pst.executeUpdate();
            JDBCUtil.close(con, pst);
            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(UserInfo userInfo) {
        Connection con = JDBCUtil.getConn();
        //创建sql
        String sql = "update userinfo SET  realname =?,gender=? where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userInfo.getRealname());
            pst.setString(2, userInfo.getGender());
            pst.setInt(3, userInfo.getId());
            int row = pst.executeUpdate();
            JDBCUtil.close(con, pst);
            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserInfo> ListAll() {
        List<UserInfo> list = new ArrayList<>();
        //获取链接
        Connection con = JDBCUtil.getConn();
        //创建sql
        String sql = "select id,loginname,realname,gender,icon from userinfo";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            //执行sql 返回记录集
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                UserInfo user = new UserInfo();
                user.setId(rst.getInt("id"));
                user.setLoginname(rst.getString("loginname"));
                user.setRealname(rst.getString("realname"));
                user.setGender(rst.getString("gender"));
                user.setIcon(rst.getString("icon"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //根据id号显示记录
    public UserInfo queryById(Integer id) {
        UserInfo user = null;
        //获取链接
        Connection con = JDBCUtil.getConn();
        //创建sql
        String sql = "select id,loginname,realname,gender,icon from userinfo where id =?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            // 执行sql返回记录集
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                user = new UserInfo();
                user.setId(rst.getInt("id"));
                user.setLoginname(rst.getString("loginname"));
                user.setRealname(rst.getString("realname"));
                user.setGender(rst.getString("gender"));
                user.setIcon(rst.getString("icon"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //登录名：添加的时候不允许重复
    public  UserInfo queryByName(String name){
        UserInfo user = null;
        //获取链接
        Connection con = JDBCUtil.getConn();
        //创建sql
        String sql = "select id,loginname,realname,gender,icon from userinfo where loginname =?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            // 执行sql返回记录集
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                user = new UserInfo();
                user.setId(rst.getInt("id"));
                user.setLoginname(rst.getString("loginname"));
                user.setRealname(rst.getString("realname"));
                user.setGender(rst.getString("gender"));
                user.setIcon(rst.getString("icon"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
