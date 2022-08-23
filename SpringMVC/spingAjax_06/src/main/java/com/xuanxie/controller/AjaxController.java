package com.xuanxie.controller;

import com.xuanxie.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/ajax1")
    public String ajaxtest1(){
        return "ajax1";
    }

    @RequestMapping("/a2")
    public String ajaxtest2(@RequestParam("username") String name,
                            @RequestParam("password") String password){
        String realPWd="111";//实际因该再数据库中查询得知
        System.out.println("requestParam"+name+"  "+password);
        String namemsg;
        String pwdmsg;
        if(name==null||"".equals(name)){
            namemsg="请输入用户名";
        }
        if(password==null||"".equals(password)){
            pwdmsg="请输入密码";
        }
        return "ajaxTest";
    }


    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="请填写";
        if(name!=null){
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="error";
            }
        }else if(pwd!=null){
            if(pwd.equals("111111")){
                msg="ok";
            }else{
                msg="error";
            }
        }
        return msg;
    }
    @RequestMapping("/getUsers")
    public List<User> ajaxGetUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User("小小","女",19));
        users.add(new User("小明","男",19));
        users.add(new User("小莉","女",19));
        users.add(new User("王五","男",19));
        users.add(new User("大傻","女",19));
        return users;
    }
}
