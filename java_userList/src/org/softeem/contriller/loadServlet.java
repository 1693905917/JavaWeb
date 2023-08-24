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

@WebServlet("/friend_demo/load")
public class loadServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       Integer id=Integer.parseInt(request.getParameter("id"));
       UserDao userDao=new UserDaoImpl();
       User userLode=userDao.findById(id);
       request.setAttribute("userLode",userLode);
//        ServletContext servletContext = getServletContext();
//        servletContext.setAttribute("userLode",userLode);
       if(userLode!=null){
           RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getContextPath()+"/friend_demo/load.jsp");
           requestDispatcher.forward(request,response);
//           response.sendRedirect("load.jsp");
       }
    }

}
