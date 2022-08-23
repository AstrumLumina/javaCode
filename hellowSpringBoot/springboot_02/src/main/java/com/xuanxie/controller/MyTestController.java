package com.xuanxie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyTestController {

    @RequestMapping("/testHello")
    @ResponseBody
    public String HelloSpringBoot(){
        return "hello SpirngBoot Test";
    }

//    @RequestMapping("/index")
//    public String toIndexInternetional(){
//        return "index";
//    }
}


