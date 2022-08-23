package com.xuanxie.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    //方法执行前,放回true则放行,进入下一个过滤器,或者进入请求,放回fase则被拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("userInf")!=null){
            return true;
        }
        //重定向到登录页
        request.getRequestDispatcher("/loginPage").forward(request,response);
        return false;
    }

    //以下可以用于添加拦截日志等
    @Override
    //请求完成后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    //请求后清理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
