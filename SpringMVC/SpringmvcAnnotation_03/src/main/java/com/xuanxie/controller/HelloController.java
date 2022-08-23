package com.xuanxie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    //注解配置请求访问路径
    @RequestMapping("/controller")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello Springmvc !!!");
        return "test";//会被视图处理器处理,即返回视图的名字(即jsp文件名)
    }
}
