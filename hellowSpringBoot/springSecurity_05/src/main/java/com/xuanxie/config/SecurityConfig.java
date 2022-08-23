package com.xuanxie.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //开启websecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll() //首页允许所有人访问
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 开启自动配置的登录功能
        // /login 请求来到登录页
        // /login?error 重定向到这里表示登录失败
        //定制登录页
          /*  loginPage指定登录时的表单显示页:若只更改此选项,登录请求为/toLogin,登录表单提交地址为toLogin
          *   也可以用loginPage指定表单页,login指定表单的提交路径
          *   定制登录页时,最好指定前端表单提交的名字,防止与默认的不一致,导致无法接收参数,无法登录
          * */
        http.formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password");


        //开启注销功能
        // /logout 注销请求,可也有字节指定注销请求地址
        //注销后默认回到登录页,我们也可自定义
        //还可一指定注销时进行一些操作 ,入清除cookies等
        http.logout().logoutSuccessUrl("/").deleteCookies();

        //关闭csrf() [用于防止网站攻击]
        //不关闭,使用get方式提交注销请求是可能失败
        //4 版本需要关闭, 5不需要关闭
        http.csrf().disable();

        //开启记住我功能  本质是一个cookies
        http.rememberMe()
                .rememberMeParameter("rememberme");//指定前端参数名

    }


    @Override
    //定义认证规则  权限管理
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*
        //在内存中定义权限   ,也可到数据库中去拿
        auth.inMemoryAuthentication()
                .withUser("xuanxie").password("123456").roles("vip1","vip2")
                .and()
                .withUser("root").password("123456").roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password("123456").roles("vip1");
*/
        /*如果报错 passwordEncoding错误,可能是因为较高版本的需要为密码指定加密方式*/
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .withUser("xuanxie").password(bCryptPasswordEncoder.encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("root").password(bCryptPasswordEncoder.encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(bCryptPasswordEncoder.encode("123456")).roles("vip1");

    }
}
