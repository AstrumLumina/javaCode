package com.xuanxie.controller;

import com.xuanxie.pojo.User;
import com.xuanxie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    UserService userServiceImpl;

    @ResponseBody
    @RequestMapping("/helloTest")
    public String HelloTest(){
        return "Hello Test";
    }

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        return userServiceImpl.getUser(new User());

    }
}
