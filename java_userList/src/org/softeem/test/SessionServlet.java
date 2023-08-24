package org.softeem.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author ASUS
 * @projectName java_userList
 * @description: Session类
 * @date 2021-09-24 11:25
 */
@WebServlet("/friend_demo/sessionTest")
public class SessionServlet extends HttpServlet
{
    //session 概念：浏览器在访问服务器的时候，
    // 服务器会创建一个session对象[内存]（该对象有唯一的ID）。
    //服务器以Cookie消息头的方式把id存储在本地的浏览器，
    // 当浏览器下一次操作的时候，会按照这个id去服务器进行匹配，就会保证这个状态

    //如何获取session？
    //默认的true:当session不存在时会默认的去创建一个session对象  最好不要用false 因为false会有空指针报错
    //HttpSession session =request.getSession(boolean b)
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //如何获取session？
        //默认的true:当session不存在时会默认的去创建一个session对象  最好不要用false 因为false会有空指针报错
        //HttpSession session =request.getSession(boolean b)
        HttpSession session = request.getSession();
        //1.获取id
        System.out.println(session.getId());
        //2.绑定数据 session.setAttribute(k,v);
        session.setAttribute("hzp", URLEncoder.encode("黄志鹏","utf-8"));
        //设置有效期  int代表天数   Cookie代表秒数
        //session也有默认存活时间，保证Session对象的存活时间，不是sessionId的存活时间
        //session.removeAttribute(sessionId);将id删了  但是Session对象还在
        //总结：Session的id与对象之间不存在包含关系
        session.setMaxInactiveInterval(1);
        //3.获取数据session.getAttribute(k);
        System.out.println(session.getAttribute("hzp"));


    }
}
