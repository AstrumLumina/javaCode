package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class EncodingTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上一次连接的时间
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
       // resp.setHeader("CharacterEncoding","utf-8");
        PrintWriter out = resp.getWriter();

        //服务器重客户端获取 cookies
        Cookie[] cookies = req.getCookies();//cookies可能有多个
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("encoding")){
                out.write(cookie.getValue());
                String sentence="你好";
                System.out.println(sentence);
                out.write(sentence);
                sentence=URLEncoder.encode(sentence,"utf-8");
                System.out.println(sentence);
                out.write(sentence);
            }
        }
        //给客户端发 cookies
        String val= URLEncoder.encode("中国字","utf8");
        Cookie cookie02= new Cookie("encoding", val);
        cookie02= new Cookie("encoding", URLEncoder.encode("中国字","utf8"));
        cookie02.setMaxAge(30);
        resp.addCookie(cookie02);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
