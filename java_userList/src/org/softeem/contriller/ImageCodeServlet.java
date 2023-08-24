package org.softeem.contriller;

import org.softeem.test.VerifyCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author ASUS
 * @projectName java_userList
 * @description: 产生验证码
 * @date 2021-09-24 20:37
 */
@WebServlet("/friend_demo/imageCode")
public class ImageCodeServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //我们需要设置返回类型为一张图片
        response.setContentType("image/jpeg");
        //获取图片的map
        Map<String, BufferedImage> map = VerifyCodeUtils.getMap();
        //获取图片
        BufferedImage image = VerifyCodeUtils.getImage(map);
        //获取图片中的用户输入的验证码
        String code = VerifyCodeUtils.getCode(map);
        HttpSession session = request.getSession();
        session.setAttribute("code",code);
        //将图片压缩出去
        ImageIO.write(image,"jpg",response.getOutputStream());
//        request.setAttribute("code",code);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/friend_demo/loginServlet");//获取绝对路径
//        //由于两个servlet共用一个request response对象
//        requestDispatcher.forward(request,response);

        //获取图片中的用户输入的验证码
//        String checkCode=request.getParameter("checkCode");
//        String code = VerifyCodeUtils.getCode(map);
//        request.setAttribute("code",code);
//        if(checkCode.equalsIgnoreCase(code.trim())){
//
//        }


    }
}
