package com.xuanxie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;


//测试类,实际使用时很少这样用,实际开发请参照MyMvcConfig
@Configuration  //使用继承就可以不用注解,使用注解就可以不继承---这句或真假未知
                //依据官方文档可知,此处必须继承WebMvcConfigurer,
                //因为配置类不许为WebMvcConfigurer 类
public class MyMvcConfigTest implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolverTest(){
        return new MyViewResolverTest();
    }


    //我们写一个静态内部类，视图解析器就需要实现ViewResolver接口
    public static class MyViewResolverTest implements ViewResolver{
        @Override
        public View resolveViewName
                (String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
