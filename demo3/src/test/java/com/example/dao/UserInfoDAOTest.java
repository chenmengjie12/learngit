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
        //根据id号删除信息
        boolean flag = userInfoDAO.delUser(5);
        //flag返回值为ture删除成功
        assertThat(flag,is(true));
    }

    @Test
    public void updateUser() {
        //更新
        UserInfo userInfo = new UserInfo();
        userInfo.setRealname("cmj");
        userInfo.setGender("女");
        userInfo.setId(6);
        //调用更新的方法
        boolean b = userInfoDAO.updateUser(userInfo);
        //布尔变量返回值用于指示操作是否成功
        assertThat(b,is(true));
    }

    @Test
    public void listAll() {
        //调用 userInfoDAO 的 ListAll 方法，返回一个 UserInfo 对象的列表。
        //List<UserInfo> 是一个泛型列表，存储 UserInfo 类型的对象。
        List<UserInfo> userInfos = userInfoDAO.ListAll();
         //使用 forEach 方法遍历 userInfos 列表。
         //对每个 UserInfo 对象，调用 System.out.println 打印其信息。
        userInfos.forEach(System.out::println);
    }

    @Test
    public void queryById() {
        //调用 userInfoDAO 的 queryById 方法，传递参数 6 返回一个 UserInfo 对象，表示 ID 为 6 的用户信息。
        UserInfo userInfo = userInfoDAO.queryById(6);
        //打印用户信息
        System.out.println(userInfo);
    }

    @Test
    public void queryByName() {
        //调用 userInfoDAO 的方法，根据用户名 "user2" 查询用户信息
        UserInfo userInfo = userInfoDAO.queryByName("user2");
        System.out.println(userInfo);
    }

    @Test
    public void login() {
        //调用 userInfoDAO 的方法，尝试使用用户名 "user2" 和密码 "123" 登录。
        UserInfo user1 = userInfoDAO.login("user2", "123");
        System.out.println(user1);
    }
}