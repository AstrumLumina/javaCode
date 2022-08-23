package com.xuanxie.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuanxie.pojo.User;
import com.xuanxie.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
//此注解表示该类下的所哟方法都不走视图解析
public class JsonTest {

    //jackson:测试

    //@ResponseBody这个注解表示,直接放回字符串,放回内容不会被解析为路径(视图)
   // @RequestMapping(value = "/j1",produces = "application/json;character=utf-8")
    //produces配置json字符解析方法,防止乱码,也可再配置文件按中同一配置
    @RequestMapping("/j1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        User user = new User("翾偰",28,"男");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        User user = new User("翾偰",28,"男");
        List<User> userList=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            userList.add(user);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userList);
        return json;
    }

    @RequestMapping("/j3")
    public String dateJson() throws JsonProcessingException {
        Date date = new Date();
        String s = new ObjectMapper().writeValueAsString(date);
        //解析后的默认格式为时间戳
        return s;
    }
    @RequestMapping("/j4")
    public String dateJson1() throws JsonProcessingException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        String s = new ObjectMapper().writeValueAsString(format);
        return s;
    }
    @RequestMapping("/j5")
    public String dateJson2() throws JsonProcessingException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(simpleDateFormat);
        String s = objectMapper.writeValueAsString(date);
        return s;
    }
    @RequestMapping("/j6")
    public String dateJson3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtil.getJson(date);
    }

    //fastJson测试
    @RequestMapping("/fj1")
    public String fastJson1() throws JsonProcessingException {
        User user = new User("翾偰",28,"男");
        String s = JSON.toJSONString(user);
        return s;
    }
    @RequestMapping("/fj2")
    public String fastJson2() throws JsonProcessingException {
        Date date = new Date();
        String s = JSON.toJSONString(date);
        return s;
    }
    @RequestMapping("/fj3")
    public String fastJson3() throws JsonProcessingException {
        Date date = new Date();
        String s = JSON.toJSONStringWithDateFormat(date,"yyyy-MM-dd HH:mm:ss");
        return s;
    }
}
