package com.xuanxie.springcloud.config;

import com.xuanxie.springcloud.service.DeptServiceFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackFactoryConfig {
    /*
    * 在DeptServiceFallbackFactory类上使用@component虽然将该类注入到容器中了
    * (可以通过上下文获得,或则再创建一个名为deptServiceFallbackFactory时报错已有该bean)
    * 当时当启动时却报错无法找到类型为DeptServiceFallbackFactory的bean,导致启动错误
    * 将该配置放到消费之类中依报该错误
    *
    * 但是奇怪的时DeptServiceCallback没有此错误
    * */
    @Bean
    public DeptServiceFallbackFactory deptServiceFallbackFactory(){
        return new DeptServiceFallbackFactory();
    }
}
