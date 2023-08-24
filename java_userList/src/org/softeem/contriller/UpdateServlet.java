package org.softeem.contriller;

import org.softeem.dao.UserDao;
import org.softeem.dao.impl.UserDaoImpl;
import org.softeem.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/friend_demo/update")
public class UpdateServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw= response.getWriter();
        String name_update=request.getParameter("name");
        String password_update=request.getParameter("pwd");
        int age_update=Integer.parseInt(request.getParameter("age"));
        int id_update=Integer.parseInt(request.getParameter("id"));
        String phone_update=request.getParameter("phone");
//        ServletContext servletContext = getServletContext();
//        User userList= (User) servletContext.getAttribute("userLode");

//        String name_update=userList.getName();
//        System.out.println("name_update"+name_update);
//        String password_update=userList.getPassword();
//        System.out.println("password_update"+password_update);
//        int age_update=userList.getAge();
//        System.out.println("age_update"+age_update);
//        int id_update=userList.getId();
//        System.out.println("id_update"+id_update);
//        String phone_update=userList.getPhone();
//        System.out.println("phone_update"+phone_update);
        UserDao userDao=new UserDaoImpl();
        User user_update=new User(id_update,password_update,name_update,age_update,phone_update);
        if(userDao.update(user_update)){
            response.sendRedirect(request.getContextPath()+"/friend_demo/login.html");
//            pw.println("修改成功");
        }
        else{
            pw.println("修改失败");
        }


    }
}
