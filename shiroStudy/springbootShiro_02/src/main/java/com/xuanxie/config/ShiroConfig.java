package com.xuanxie.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //创建 realm对象 需要自定义该类
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //defaultWebSecurityManager
    //@Qualifier:关联容器中的bean,用于注入
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(realm);
        return securityManager;
    }

    //shiroFillterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean
    (@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //根据权限进行拦截

        //添加shiro内置的过滤器
        /*
        * anon:无需认证就可以访问
        * authc:必须认证才能访问
        * user:必须拥有记住我功能才能访问
        * perms:用于堆某个资源的访问权限才能访问
        * role: 拥有对某个角色的权限才能访问
        * */
        Map<String,String> filterMap=new LinkedHashMap<String,String>();
        filterMap.put("/user/add","perms[user:add]");//需要访问者是用户,且拥有add权限,才能访问
        filterMap.put("/user/updata","authc");//需要被认证的用户才可以访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //设置登录页
        //当权权限不足时会自动条转到该页面然用户登录
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //设置访问为经授权地址时 跳转的请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorized");

        return shiroFilterFactoryBean;
    }


    //整合shrio和thymeleaf
    @Bean
    public ShiroDialect/*shiro方言*/ getShiroDialect(){
        return new ShiroDialect();
    }


}
