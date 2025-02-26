package com.example.dao;

import com.example.pojo.MenuInfo;
import org.junit.Test;

import java.util.List;

public class MenuInfoDAOTest {
    MenuInfoDAO menuInfoDAO = new MenuInfoDAO();
    @Test
    public void listByCid() {
        List<MenuInfo> menuInfos = menuInfoDAO.listByCid(5, 3);
        menuInfos.forEach(System.out::println);
    }
}