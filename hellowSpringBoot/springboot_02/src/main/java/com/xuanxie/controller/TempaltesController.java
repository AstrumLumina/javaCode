package com.xuanxie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TempaltesController {

    @RequestMapping("/test")
    public String templatesControl(Model mv){
        mv.addAttribute("msg","使用thymeleaf取值");
        return "test";
    }

    @RequestMapping("/test2")
    public String templatesControl2(Model mv){
        mv.addAttribute("htmlContent","<h1>使用thymeleaf取值</h1>");
        mv.addAttribute("users", Arrays.asList("用户1","用户2","用户3","用户4"));
        return "test2";
    }
}
