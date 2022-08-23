package com.xuanxie.appConfig;

import com.xuanxie.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*可以使用该java配置代替xml文件
@configuration类似@component
该类注解注释的类也会被注册容器中
*  */
@Configuration
@ComponentScan("com.xuanxie.pojo")
public class MyConfig {

    @Bean
    public Person getPerson(){
        return new Person();
    }
}
