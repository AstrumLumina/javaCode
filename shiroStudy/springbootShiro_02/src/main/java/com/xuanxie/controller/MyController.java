package com.xuanxie.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping ({"/","/index","/index.xml"})
    public String toIndexPage(){
        return "index";
    }


    @RequestMapping ("/user/add")
    public String toAddPage(){
        return "add";
    }

    @RequestMapping ("/user/updata")
    public String toUpdataPage(){
        return "updata";
    }

    @RequestMapping ("/tologin")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping ("/login")
    public String login
            (@RequestParam("username") String username,
             @RequestParam("password") String password,
             Model model)
    {

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //获取令牌  封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录的方法,如果没有异常,则登录成功
            //登录成功后往shiro session中放入信息
            SecurityUtils.getSubject().getSession().setAttribute("loginuser","已登录");
        }catch (UnknownAccountException e){
            model.addAttribute("msg","账户不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","用户名密码错误");
            return "login";
        }catch (LockedAccountException e){
            model.addAttribute("msg","账户被锁定");
            return "login";
        }catch (AuthenticationException e){
            model.addAttribute("msg","登录异常");
            return "login";
        }
        return "index";
    }

    @RequestMapping ("/unAuthorized")
    @ResponseBody
    public String unAuthorizedPage(){
        //return "UnAuthorized";
        return "未经授权,禁止访问该页面";
    }

    @RequestMapping ("/loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "index";
    }


}
