package com.xuanxie.filter;


import javax.servlet.*;
import java.io.IOException;

public class CharEncodFilter implements Filter {
    @Override//初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ChracterEncodingFilter被初始化");
    }

    @Override//过滤
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("ChracterEncodingFilter执行前");
        chain.doFilter(request,response);//放行，如果不写，则会卡在这里
        System.out.println("ChracterEncodingFilter执行后");
        /*
        * chain:链
        * 过滤中所有的代码，再过滤特定的请求时都会执行
        * 必须要让过滤器继续通行
        *
        * */

    }

    @Override//销毁
    public void destroy() {
        System.out.println("ChracterEncodingFilter被销毁");
        System.gc();//通知垃圾回收,没必要
    }
}
