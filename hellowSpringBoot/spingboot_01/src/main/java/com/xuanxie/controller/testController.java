package com.xuanxie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class testController {

    @RequestMapping("/hello")
    public String helloSpringBoot(){
        return "helloSpringBoot";
    }
}
