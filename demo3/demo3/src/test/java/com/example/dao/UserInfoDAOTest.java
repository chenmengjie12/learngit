package com.example.dao;

import com.example.pojo.UserInfo;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserInfoDAOTest {
    UserInfoDAO userInfoDAO = new UserInfoDAO();
    @Test
    public void list() {
    }

    @Test
    public void addUser() {
        UserInfo userInfo = new UserInfo();
        //设置登录名
        userInfo.setLoginname("test5");
        //设置密码
        userInfo.setRealname("李宁");
        //设置密码
        userInfo.setPass("123");
        //设置性别
        userInfo.setGender("男");
        //设置头像
        userInfo.setIcon("./imgs/icon4.png");
        boolean b = userInfoDAO.addUser(userInfo);
        assertThat(b,is(true));
    }

    @Test
    public void delUser() {
        boolean flag = userInfoDAO.delUser(5);
        assertThat(flag,is(true));
    }

    @Test
    public void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setRealname("cmj");
        userInfo.setGender("女");
        userInfo.setId(6);
        boolean b = userInfoDAO.updateUser(userInfo);
        assertThat(b,is(true));
    }

    @Test
    public void listAll() {
        List<UserInfo> userInfos = userInfoDAO.ListAll();
        userInfos.forEach(System.out::println);
    }

    @Test
    public void queryById() {
        UserInfo userInfo = userInfoDAO.queryById(6);
        System.out.println(userInfo);
    }

    @Test
    public void queryByName() {
        UserInfo userInfo = userInfoDAO.queryByName("user2");
        System.out.println(userInfo);
    }

    @Test
    public void login() {
        UserInfo user1 = userInfoDAO.login("user2", "123");
        System.out.println(user1);
    }
}