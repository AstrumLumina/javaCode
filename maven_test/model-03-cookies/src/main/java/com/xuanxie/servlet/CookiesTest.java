package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookiesTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上一次连接的时间
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        //服务器重客户端获取 cookies
        Cookie[] cookies = req.getCookies();//cookies可能有多个
        if(cookies!=null){
           // out.write("你上一次访问本站的时间是:");
            for (Cookie cookie :cookies ) {
                if(cookie.getName().equals("name")){
                    System.out.println("您的name 为:"+cookie.getValue());
                    out.write("您的name 为:"+cookie.getValue());

                }else if(cookie.getName().equals("latesttime")){
                    long lasttime=Long.parseLong(cookie.getValue());
                    Date date = new Date(lasttime);
                    out.write("你上次访问本站的时间为:"+date.toLocaleString());
                    System.out.println(("你上次访问本站的时间为:" + date.toLocaleString()));

                }
            }
        }else{
            out.write("这是您第一次访问本站,还没有cookie,我么无法知道你上次访问的时间!!!!!");
        }
        //给客户端发 cookies
        Cookie cookie1 = new Cookie("name", "xuanxie");
        Cookie timecookie = new Cookie("latesttime", System.currentTimeMillis() + "");

        //设置cookies的有效时长,保证安全
        timecookie.setMaxAge(30);//以秒为单位
        cookie1.setMaxAge(30);

        resp.addCookie(timecookie);
        resp.addCookie(cookie1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
