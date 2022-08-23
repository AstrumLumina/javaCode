package com.xuanxie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 全面接管即：SpringBoot对SpringMVC的自动配置不需要了，所有都是我们自己去配置！
只需在我们的配置类中要加一个@EnableWebMvc。
* */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/test3 ， 就会跳转到test2页面；
        registry.addViewController("/test3").setViewName("test2");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    //自定义的fillter类生效
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginIntercept())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login","/index","index.html","/loginPage","/");
//    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    //国际化页面取值出错
//    @Bean
//    public ResourceBundleMessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setFallbackToSystemLocale(false);
//        messageSource.setBasenames("i18n.login");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(2);
//        return messageSource;
//    }


}

