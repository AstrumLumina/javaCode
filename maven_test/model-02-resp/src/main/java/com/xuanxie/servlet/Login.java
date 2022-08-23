package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.font.ShapeGraphicAttribute;
import java.io.IOException;
import java.util.Arrays;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbys=req.getParameterValues("hobbys");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println(Arrays.toString(hobbys));

        req.getRequestDispatcher("/successed.jsp").forward(req,resp);
        //注意这个 / 代表当前项目路径,故不需要在加上项目路径


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
