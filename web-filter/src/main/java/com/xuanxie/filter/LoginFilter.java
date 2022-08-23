package com.xuanxie.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest=(HttpServletRequest)request;
        HttpServletResponse hresponse=(HttpServletResponse) response;
        if (hrequest.getSession().getAttribute("USE_SESSION")==null) {
             hresponse.sendRedirect("/f/index.jsp");//登录失败,过滤掉
        }else{
            //登录成功,不管他,按照原来的登录路径登录
            //hresponse.sendRedirect("/f/sys/app.jsp");//若加上这句
            //会导致不断的过滤,而陷入死循环,卡死
        }
        System.out.println("登录过滤");
        System.out.println(hrequest.getSession().getAttribute("USE_SESSION"));

        //牢记过滤后要放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
