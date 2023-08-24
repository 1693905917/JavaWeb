package org.softeem.test;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
@WebServlet(value="/friend_demo/onetestServlet")
public class OnetestServlet extends HttpServlet {

    static int num;
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
            num++;
        System.out.println("登入次数："+(num));
    }
}
