package com.xuanxie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        session.setAttribute("userInf",username);
        return "main";
    }
    @RequestMapping("/destory")
    public String destoryUsr(HttpSession session){
        if(session.getAttribute("userInf")!=null){
            session.removeAttribute("userInf");
        }
        return "redirect:/index.jsp";
    }
}
