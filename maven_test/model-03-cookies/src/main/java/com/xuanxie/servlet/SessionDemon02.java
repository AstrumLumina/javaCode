package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemon02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止乱码
        req.setCharacterEncoding("UTF8");
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("text/html;charset=UTF8");

        String name=null;
        SessionTest.person person1=null;
        try{
            //获得session
            HttpSession session = req.getSession();
            name=(String)session.getAttribute("name");
            //获得session 中的对象
              person1= (SessionTest.person)session.getAttribute("person");

            //删除内容
            session.removeAttribute("name");
            session.removeAttribute("person");

        }catch(Throwable e){
            e.printStackTrace();
            resp.getWriter().write("there ar no attribute! plaease go back!");
        }
        System.out.println(name);
        resp.getWriter().write(name);
        resp.getWriter().write(person1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
