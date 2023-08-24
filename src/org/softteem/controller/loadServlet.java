package org.softeem.contriller;

import org.softeem.dao.UserDao;
import org.softeem.dao.impl.UserDaoImpl;
import org.softeem.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class loadServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        String username=request.getParameter("username");
//        String password=request.getParameter("pwd");
//        PrintWriter pw= response.getWriter();//相应对象  从网页写
//        UserDao userDao=new UserDaoImpl();
//        User user_1=userDao.login(username,password);
//        //全部显示
//        List<User> userList=userDao.findAll();
//        request.setAttribute("userList",userList);
//        if(userList!=null)
//        {
//            //创建成功
//            RequestDispatcher requestDispatcher_1 = request.getRequestDispatcher("load.jsp");
//            requestDispatcher_1.forward(request,response);
//        }
//        else {
//            pw.println("用户存在");
//        }


    }

}
