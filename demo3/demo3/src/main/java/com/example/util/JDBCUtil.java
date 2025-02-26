package com.example.util;

import java.sql.*;

public class JDBCUtil {
    private static String url = "jdbc:mysql://localhost:3306/hcd?characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "";
    public  static Connection getConn(){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection con, PreparedStatement pst){

        try {
            if(pst!=null){
                pst.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void close(ResultSet rst, PreparedStatement pst, Connection con){

        try {
            if(pst!=null){
                pst.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
