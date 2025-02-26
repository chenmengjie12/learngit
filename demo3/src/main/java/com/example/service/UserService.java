package com.example.service;

import com.example.dao.UserInfoDAO;
import com.example.pojo.UserInfo;

import java.util.List;

public class UserService {
    private UserInfoDAO userInfoDAO = new UserInfoDAO();
    //登录
    public  UserInfo login(String name,String pass){
        return userInfoDAO.login(name,pass);
    }
    //显示记录
    public List<UserInfo> list(){
        return userInfoDAO.ListAll();
    }
    //添加
    public boolean add(UserInfo user){
        return userInfoDAO.addUser(user);
    }
    //更新
    public boolean upd(UserInfo user){
        return userInfoDAO.updateUser(user);
    }
    //删除
    public boolean del(Integer id){
        return userInfoDAO.delUser(id);
    }
    //根据id查询
    public UserInfo selectOne(Integer id){
        return userInfoDAO.queryById(id);
    }
    //根据登录名查询

    public UserInfo queryByName(String name) {
        return userInfoDAO.queryByName(name);
    }
}
