package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //防止乱码
        req.setCharacterEncoding("UTF8");
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("text/html;charset=UTF8");

        //获得session
        HttpSession session = req.getSession();

        //在session中存放东西
        session.setAttribute("name","xuanxie");
        //存放对象
        session.setAttribute("person",new person("petter",18,true));

        //获取session 的ID
        String id = session.getId();

        //判断session是不是新建的{
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功,ID:" + id);
        }else {
            resp.getWriter().write("session 已经在服务器中存在,id:"+id);
        }
//猜想session做了什么
//        Cookie cookie = new Cookie("JSESSIONID", id);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    static class person{
        private String name;
        private int age;
        private boolean isboy;
        public person(String name,int age, boolean isboy){
            this.age=age;
            this.isboy=isboy;
            this.name=name;
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", isboy=" + isboy +
                    '}';
        }
    }
}
