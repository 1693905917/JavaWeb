package org.softeem.dao.impl;

import org.softeem.dao.UserDao;
import org.softeem.pojo.User;
import org.softeem.util.DBUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
     Connection conn=null;
     Statement st=null;
     ResultSet rs=null;
     PreparedStatement ps=null;


//    @Override
    public List<User> findAll() {
        //获取链接
        conn= DBUtils.getConn();
        String sql="select * from friend_user";
        List<User> list=new ArrayList<>();
        try {
            //2.定义sql语句，获取语句处理对象
             st = conn.createStatement();
             rs=st.executeQuery(sql);
             //3.遍历结果集

            while(rs.next()){
                User User=new User();
                User.setId(rs.getInt("id"));
                User.setUsername(rs.getString("username"));
                User.setPassword(rs.getString("password"));
                User.setName(rs.getString("name"));
                User.setAge(rs.getInt("age"));
                User.setGender(rs.getString("gender"));
                User.setPhone(rs.getString("phone"));
                list.add(User);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        finally {
            DBUtils.close(conn,st,rs);
        }

        return list;


    }

//    @Override
//    //根据用户名查找用户
//    public User findUserByUserName(String name) {
//        conn=DBUtils.getConn();
//        User user_1=new User();
//        String sql="select * from `friend_user` where `username`=?";
//        try {
//            ps=conn.prepareStatement(sql);
//            ps.setString(1,name);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                user_1.setId(rs.getInt("id"));
//                user_1.setUsername(rs.getString("username"));
//                user_1.setPassword(rs.getString("password"));
//                user_1.setName(rs.getString("name"));
//                user_1.setAge(rs.getInt("age"));
//                user_1.setGender(rs.getString("gender"));
//                user_1.setPhone(rs.getString("phone"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return user_1;
//    }



//    @Override
    public boolean update(User user_1) {
        conn=DBUtils.getConn();
        String sql="update friend_user set `username`=? where id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,user_1.getUsername());
            ps.setInt(2,user_1.getId());
            return  ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override//插入用户
    public boolean insert(User user_1) {
        conn=DBUtils.getConn();
        String sql="insert into friend_user values(?,?,?,?,?,?,?);";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,user_1.getId());
            ps.setString(2,user_1.getUsername());
            ps.setString(3,user_1.getPassword());
            ps.setString(4,user_1.getName());
            ps.setInt(5,user_1.getAge());
            ps.setString(6,user_1.getGender());
            ps.setString(7,user_1.getPhone());
            return  ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override//删除用户
    public boolean delete(int id) {
        conn=DBUtils.getConn();
        String sql="delete from friend_user where id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            return  ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
    public User login(String username, String password) {
        String sql="select * from friend_user where username=? and password=?";
        conn= DBUtils.getConn();
        User user=new User();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setPhone(rs.getString("phone"));
               return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(conn,st,rs);
        }
        return null;
    }



//    @Override
//    public boolean register(String username, String name, String password, int age, String gender,String phone) {
//        String sql="insert into friend_user(username,name,password,age,gender,phone) values(?,?,?,?,?,?);";
//        conn=DBUtils.getConn();
//        try {
//            ps=conn.prepareStatement(sql);
//            ps.setString(1,username);
//            ps.setString(2,name);
//            ps.setString(3,password);
//            ps.setInt(4,age);
//            ps.setString(5,gender);
//            ps.setString(6,phone);
//            return  ps.executeUpdate()>0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
