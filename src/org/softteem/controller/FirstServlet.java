package org.softteem.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Servlet里面有很多实现类
//GenericServlet
//HttpServlet-->里面是封装的Http协议的servlet
//网页地址的：http://localhost:8089/
public class FirstServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //设置相应的数据类型和编码方式
        //要么相应文本方式要么相应html网页  使用的编码设置是utf-8
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw= response.getWriter();//相应对象  从网页写
        pw.println("我的第一次servlet");

    }
}
