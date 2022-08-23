package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookiesDemon2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上一次连接的时间
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //服务器重客户端获取 cookies
        Cookie[] cookies = req.getCookies();//cookies可能有多个
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getValue());
        }
        //给客户端发 cookies
        Cookie cookie02= new Cookie("Demon02", "age");
        cookie02.setMaxAge(5);
        resp.addCookie(cookie02);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}


