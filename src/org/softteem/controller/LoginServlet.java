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

public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //设置相应的数据类型和编码方式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //要么相应文本方式要么相应html网页  使用的编码设置是utf-8
        String username=request.getParameter("username");
        String password=request.getParameter("pwd");
        PrintWriter pw= response.getWriter();//相应对象  从网页写
        //JDBC:数据库
        UserDao userDao=new UserDaoImpl();
        User user=userDao.login(username,password);
        //全部显示
        List<User> userList=userDao.findAll();
        request.setAttribute("userList",userList);
        if(user!=null)
        {
            //创建成功
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userList.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            pw.println("用户存在");
        }
    }
}
