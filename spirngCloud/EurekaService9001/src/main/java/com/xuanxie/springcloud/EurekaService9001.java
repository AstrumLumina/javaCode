package com.xuanxie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka服务注册与发现功能
public class EurekaService9001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService9001.class);
    }
}
