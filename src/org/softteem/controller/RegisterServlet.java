package org.softteem.controller;



import org.softteem.dao.UserDao;
import org.softteem.dao.impl.UserDaoImpl;
import org.softteem.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //设置相应的数据类型和编码方式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw= response.getWriter();//相应对象  从网页写
        String username=request.getParameter("username");
        String name=request.getParameter("name");
        String password=request.getParameter("pwd");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        String phone=request.getParameter("phone");
        UserDao userDao=new UserDaoImpl();
        int id=0;
        User user=new User(id,username,password,name,age,gender,phone);
        if(userDao.insert(user))
        {
//            创建成功！
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            pw.println("用户存在！");
        }


    }
}
