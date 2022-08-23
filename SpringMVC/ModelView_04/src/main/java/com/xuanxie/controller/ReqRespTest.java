package com.xuanxie.controller;


import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ReqRespTest {
    //利用原来的进行重定向
    @RequestMapping("/reqresp")
    public String reqRespTest(HttpServletRequest req, HttpServletResponse response) throws IOException {
        //对于前端的参数和请求中携带的参数可以直接才函数参数中获取,
        //也可以获取req对象后像原来一样获取,
        //还可以利用req和resp对象进行转发和重定向操作
        response.getWriter().println("拿到的req和resp对象,并返回给了前端");
        return "test";
    }

    //springmvc的重定向和转发
    @RequestMapping("/spring1")
    public String springDispa(Model model)  {
        model.addAttribute("msg","sprignmvc转发向");
        /*
        * "/test"和"test"一样,都是解析视图
        * 和"forward:/test"都是转发,路径路径不会被解析
        * */
        return "forward:/index.jsp";
    }
    @RequestMapping("/spring2")
    public String springRedirect(Model model)  {
        model.addAttribute("msg","sprignmvc重定向");
        /*
         * "redirect:/test"是重定向,路径不会被解析
         * */
        return "redirect:/index.jsp";
    }

    @RequestMapping("/restful/{a}/{b}")
    public String resuful(@PathVariable int a, @PathVariable int b,Model model){
        model.addAttribute("msg",a+b);
        return "test";
    }
    @RequestMapping(value = "/restful/{a}/{b}",method = RequestMethod.GET)
    public String resuful2(@PathVariable int a, @PathVariable int b,Model model){
        model.addAttribute("msg",a+b);
        return "test";
    }
    @RequestMapping(value = "/restful/{a}/{b}",method = RequestMethod.POST)
    public String resuful3(@PathVariable int a, @PathVariable int b,Model model){
        model.addAttribute("msg",a+b);
        return "test2";
    }

    @RequestMapping("/dealparam")
    public String getParam( @RequestParam("username")String name,Model model){
        model.addAttribute("msg","得到了前端的参数为"+name);
        return "test";
    }
}

