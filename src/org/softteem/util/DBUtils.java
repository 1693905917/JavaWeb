package org.softeem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    //1.初始化属性值
    public static String DRIVER;
    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;

    //2.如何将静态变量赋值-->通过静态代码块
    static {
        try {
            Properties pro=new Properties();
//            pro.load(DBUtils.class.getResourceAsStream("db.properties"));
            pro.load(new FileInputStream("D://Java//IDEA_Practice//java_web_pro//java_userList//src//org//softeem//util//db.properties"));
            DRIVER= pro.getProperty("driver");
            URL= pro.getProperty("url");
            USERNAME= pro.getProperty("username");
            PASSWORD= pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //3.获取链接
    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //4.释放资源
    public static  void close(Connection conn, Statement st, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(st!=null){
                st.close();
            }
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
