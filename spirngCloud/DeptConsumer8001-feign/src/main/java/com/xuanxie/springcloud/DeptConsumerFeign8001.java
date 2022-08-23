package com.xuanxie.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication  //(scanBasePackages = {"com.xuanxie.springcloud", "com.xuanxie.springcloud.service"})
@EnableEurekaClient
@EnableFeignClients(basePackages ={"com.xuanxie.springcloud.service"})
//@ComponentScans({@ComponentScan(basePackages = "com.xuanxie.springcloud.service")})
//@EnableHystrix  //开启允许被监控
public class DeptConsumerFeign8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign8001.class);
    }

}
