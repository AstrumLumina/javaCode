package com.xuanxie.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class HellowServlet extends HttpServlet {
        @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse respnse) throws IOException {
            respnse.setContentType("text/html");
            PrintWriter out=respnse.getWriter();
            System.out.println("java class helloservlet");
            out.println("hellow you have successfully achieved the java class helloservlet");
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
