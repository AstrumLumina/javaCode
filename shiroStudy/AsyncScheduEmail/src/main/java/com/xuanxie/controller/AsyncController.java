package com.xuanxie.controller;

import com.xuanxie.AsyncService.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AsyncController {

    @Autowired
    service myService;

    @ResponseBody
    @RequestMapping("/getService")
    public String test_01(){
        myService.myAsyncService();
        return "异步请求成功";
    }
}
