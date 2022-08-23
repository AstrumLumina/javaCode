package com.xuanxie.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextContactTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter();//初始化参数
//        this.getServletConfig();//servlet 配置
//        this.getServletContext();//获取上下文信息
        ServletContext servletContext = this.getServletContext();
        String username="xuanxie";//数据
        servletContext.setAttribute("username",username);//设置添加数据  键值对 数据名 数据

        System.out.println("hellow servlet ,i have set servlectcontext  username="+username);

    }
}
