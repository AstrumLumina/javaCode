package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传来的参数
        String username =  req.getParameter("username");

        if(username.equals("xuanxie")){
            req.getSession().setAttribute("USE_SESSION",req.getSession().getId());
            resp.sendRedirect("/f/sys/app.jsp");//登录成功
        }else {//登录失败
            resp.sendRedirect("/f/notlogin.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
