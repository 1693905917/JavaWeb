package org.softeem.test;

import javax.servlet.annotation.WebServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author ASUS
 * @projectName java_userList
 * @description: 验证码工具类
 * @date 2021-09-24 20:17
 */
public class VerifyCodeUtils {
    //画图的方法 GUI
    //Map<String, BufferedImage>  String代表图片上的内容  BufferedImage代表图片对象
    public static Map<String, BufferedImage> getMap(){
        //1.构建一张白色图片---->RGB
        BufferedImage image=new BufferedImage(200,70,BufferedImage.TYPE_3BYTE_BGR);
        //2.得到画笔
        Graphics g=image.getGraphics();
        //3.设置画笔的颜色
        g.setColor(Color.WHITE);
        //4.给图片填充背景颜色
        g.fillRect(0,0,200,70);
        //5.画一个边框
        g.setColor(Color.BLACK);
        g.drawRect(0,0,199,69);
        //6.画内容
        StringBuffer sb=new StringBuffer();
        //获取随机对象
        Random rd=new Random();
        //画4个字符
        for(int i=0;i<4;i++){
            //7.1随机颜色
            Color c=new Color(rd.nextInt(256),rd.nextInt(256),rd.nextInt(256));
            //7.2随机的字符
            char ch=(char)(rd.nextInt(26)+65);
            g.setColor(c);
            Font font=new Font("楷体",Font.BOLD,30);
            g.setFont(font);
            g.drawString(ch+"",30+45*i,45);
            //将字符串保存起来
            sb.append(ch);
        }
        Map<String,BufferedImage> map=new HashMap<>();
        map.put(sb.toString(),image);
        return map;
    }
    //迭代获取map的图片
    public static BufferedImage getImage(Map<String,BufferedImage> map){
        Set<Map.Entry<String,BufferedImage>> entries= map.entrySet();
        //由于集合中只有一个图片和内容
        return entries.iterator().next().getValue();
    }
    //迭代获取map的答案
    public  static String getCode(Map<String,BufferedImage> map){
        Set<Map.Entry<String,BufferedImage>> entries= map.entrySet();
        //由于集合中只有一个图片和内容
        return entries.iterator().next().getKey();
    }
}
