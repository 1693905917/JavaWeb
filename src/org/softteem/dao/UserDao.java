package org.softeem.dao;

import org.softeem.pojo.User;


import java.util.List;

//DAO:Data Access Object
public interface UserDao {
    //查询所有用户
    List<User> findAll();
//    根据用户名查找用户
//    User findUserByUserName(String name);

//    修改用户
    boolean update(User user_1);
//
//    插入用户
    boolean insert(User user_1);

    //删除用户
    boolean delete(int id);

    User login(String username,String password);



//    boolean register(String username,String name,String password,int age,String gender,String phone);

}
