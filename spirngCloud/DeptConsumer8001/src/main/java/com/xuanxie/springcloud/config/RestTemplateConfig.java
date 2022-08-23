package com.xuanxie.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.xuanxie.myRule.MyDiyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean  //配置RestTemplate
    @LoadBalanced  //要开启负载均衡,才能开启通过服务名调用服务的用法
    /*
    * @loadBalance注解修饰的restTemplate才能实现服务名的调用，
    * * 没有修饰的restTemplate是没有该功能的。原因就是当使用微服务名称的时候，
    * * 可能有多个服务提供者，restTemplate不知道去调用哪个服务提供者，
    * * 只有设置负载均衡之后服务消费者才会去访问某个微服务提供者
    * * ，这个负载均衡的功能我是使用Ribbon提供的*/
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //配置服务在均衡的策略
    //@Bean
    public IRule myRule(){
        return new RandomRule();//使用随机策略
    }

}
