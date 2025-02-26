package com.example.util;

import java.sql.*;

public class JDBCUtil {
    //连接url
    private static String url = "jdbc:mysql://localhost:3306/hcd?characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "";
    public  static Connection getConn(){
        try {
            //建立与数据库的链接
            Connection con = DriverManager.getConnection(url, username, password);
            //如果连接成功，返回这个 Connection 对象
            return con;
            //捕获可能抛出的 SQLException，这是在尝试连接数据库时可能发生的异常
        } catch (SQLException e) {
            //如果发生 SQLException，抛出一个新的 RuntimeException，并将原始异常作为参数传递
            throw new RuntimeException(e);
        }
    }
    //确保数据库连接和语句对象在使用后被正确关闭，以防止资源泄漏
    public static void close(Connection con, PreparedStatement pst){

        try {
            if(pst!=null){
                //关闭 PreparedStatement
                pst.close();
            }
            if (con!=null){
                //关闭 Connection
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
