package com.xuanxie.providerserve.service.controller;

import com.xuanxie.service.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    GetService getService;

    @RequestMapping("/getService")
    @ResponseBody
    public String getServiceFromAnothorComputer(){
        return getService.consumerGetService();
    }
}
