package com.example.dao;

import com.example.pojo.MenuInfo;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuInfoDAO {
    public List<MenuInfo> listByCid(int cid, int limitcount){
        List<MenuInfo> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConn();
        //查询 hcd_menu 表中指定分类ID的记录，按创建时间降序排列，并限制返回数量
        String sql =  "select * from hcd_menu where cid = ? order by mcreatetime desc limit ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,cid);
            pst.setInt(2,limitcount);
            ResultSet rst = pst.executeQuery();
            while (rst.next()){
                MenuInfo m = new MenuInfo();
                m.setMid(rst.getInt("mid"));
                m.setMname(rst.getString("mname"));
                m.setPrice(rst.getDouble("price"));
                m.setNum(rst.getInt("num"));
                m.setPic(rst.getString("pic"));
                m.setCid(rst.getInt("cid"));
                m.setSales(rst.getInt("sales"));
                m.setMcreatetime(rst.getString("mcreatetime"));
                list.add(m);
            }
            JDBCUtil.close(rst,pst,conn);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
