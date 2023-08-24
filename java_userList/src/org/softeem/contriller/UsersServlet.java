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
@WebServlet("/friend_demo/usersServlet")
public class UsersServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw= response.getWriter();
        UserDao userDao=new UserDaoImpl();
        List<User> userList=userDao.findAll();
//        request.setAttribute("userList",userList);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("userList",userList);
        if(userList!=null)
        {
            //创建成功
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getContextPath()+"/friend_demo/userList.jsp");  //更安全
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userList.jsp");
            requestDispatcher.forward(request,response);
//            response.sendRedirect("userList.jsp");
        }
    }
}
