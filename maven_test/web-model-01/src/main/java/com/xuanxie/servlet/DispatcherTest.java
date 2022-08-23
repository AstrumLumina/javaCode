package com.xuanxie.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/getparam");//参数为转发的地址 请求路径  设置路径
        requestDispatcher.forward(req,resp);//调用forward()请求转发
        /* 此处只是该页面显示的内容为转发出的内容,当地址并未发生改变,相当于把请求转发处的内容传到该页面来了
        * 重定向则是直接跳转到其他页面
        * */

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
