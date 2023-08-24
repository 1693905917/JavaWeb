package org.softeem.contriller;

import org.softeem.dao.UserDao;
import org.softeem.dao.impl.UserDaoImpl;
import org.softeem.pojo.User;
import org.softeem.test.VerifyCodeUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet("/friend_demo/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //设置相应的数据类型和编码方式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, BufferedImage> map = VerifyCodeUtils.getMap();
        //要么相应文本方式要么相应html网页  使用的编码设置是utf-8
        String username=request.getParameter("username");
        String password=request.getParameter("pwd");
        String remb=request.getParameter("remb");
        String checkCode=request.getParameter("checkCode");
        //获取客户输入的验证码
        HttpSession session = request.getSession();
        String code=(String) session.getAttribute("code");
        PrintWriter pw= response.getWriter();//相应对象  从网页写
        //JDBC:数据库
        UserDao userDao=new UserDaoImpl();
        User userLogin=userDao.login(username,password);
//        request.setAttribute("userLogin",userLogin);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("userLogin",userLogin);
        if((userLogin!=null)&&(checkCode.equalsIgnoreCase(code)))
        {
            if("1".equalsIgnoreCase(remb)) {
                Cookie cookie1 = new Cookie("username1", URLEncoder.encode(username, "utf-8"));
                Cookie cookie2 = new Cookie("paw1", password);
                Cookie cookie3 = new Cookie("remb", remb);
                cookie1.setMaxAge(60 * 10);
                cookie2.setMaxAge(60 * 10);
                cookie3.setMaxAge(60 * 10);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);
            }
            //创建成功  转换
            //通过转器  RequestDispatcher  跳转到哪个网页
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getContextPath()+"/friend_demo/usersServlet");//获取绝对路径
            //由于两个servlet共用一个request response对象
            requestDispatcher.forward(request,response);
//            response.sendRedirect("usersServlet");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/friend_demo/login.html");
        }
    }
}
