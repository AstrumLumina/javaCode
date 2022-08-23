package com.xuanxie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/*
* 就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
* 基本就是EnableEurekaClient有@EnableDiscoveryClient的功能，
另外上面的注释中提到，其实@EnableEurekaClient注解就是一种方便使用eureka的注解而已，
可以说使用其他的注册中心后，都可以使用@EnableDiscoveryClient注解，
但是使用@EnableEurekaClient的情景，就是在服务采用eureka作为注册中心的时候，使用场景较为单一
* */


@SpringBootApplication
//@EnableEurekaClient //开启eureka服务注册
@EnableDiscoveryClient //feign需要用这个注解
@EnableCircuitBreaker  //开启服务熔断
public class DeptProviderFeign7001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderFeign7001.class);
    }
}

//开启服务发现,可以自定义一些信息,
//该注解版我们把这些信息放到一个请求中,并将地址放到eureka监控页
// 面,方便了解该拆分的微服务的信息,便于团队管理