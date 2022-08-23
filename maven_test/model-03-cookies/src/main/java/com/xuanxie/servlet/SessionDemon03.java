package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemon03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止乱码
        req.setCharacterEncoding("UTF8");
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("text/html;charset=UTF8");

        //获得session
        HttpSession session = req.getSession();
        String name=null;
        try{

            name=(String)session.getAttribute("name");
            //删除内容
            session.removeAttribute("name");
        }catch(Throwable e){
            e.printStackTrace();
            resp.getWriter().write("there ar no attribute! plaease go back!");
        }
        System.out.println(name);
        resp.getWriter().write(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
