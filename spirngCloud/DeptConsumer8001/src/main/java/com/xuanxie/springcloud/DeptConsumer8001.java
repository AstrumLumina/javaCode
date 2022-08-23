package com.xuanxie.springcloud;

import com.xuanxie.myRule.MyDiyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "DEPT-PROVIDER",configuration= MyDiyRuleConfig.class)  //为指定服务开启开启负载均衡
// 指定自定义的负载均衡策略配置类,如果使用非自定义的策略,则不需要配置configuration项
public class DeptConsumer8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8001.class);
    }
}
