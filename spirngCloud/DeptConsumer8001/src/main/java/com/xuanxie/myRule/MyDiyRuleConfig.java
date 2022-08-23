package com.xuanxie.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDiyRuleConfig {
    //使用自定义的负载均衡策略
    @Bean
    public IRule myDiyRule(){
        return new MyDiyRule();
    }
}
