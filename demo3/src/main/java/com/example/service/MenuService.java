package com.example.service;

import com.example.dao.MenuInfoDAO;
import com.example.pojo.MenuInfo;

import java.util.List;

public class MenuService {
    private MenuInfoDAO menuInfoDAO = new MenuInfoDAO();
    public List<MenuInfo> listByCid(int cid, int limitcount){
        return menuInfoDAO.listByCid(cid,limitcount);
    }
}
