package com.xuanxie.springcloud.config;

import com.xuanxie.springcloud.service.DeptServiceFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
*  Incompatible fallbackFactory instance. Fallback/fallbackFactory of type class com.xuanxie.springcloud.service.DeptServiceHystrixFallbackFacto is not assignable to interface feign.hystrix.FallbackFactory for feign client DEPT-PROVIDER
	at org.springframework.cloud.openfeign.HystrixTargeter.getFromContext

	org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.xuanxie.springcloud.service.DeptClienService': Unexpected exception during bean creation; nested exception is java.lang.IllegalStateException: Incompatible fallbackFactory instance. Fallback/fallbackFactory of type class com.xuanxie.springcloud.service.DeptServiceHystrixFallbackFacto is not assignable to interface feign.hystrix.FallbackFactory for feign client DEPT-PROVIDER
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry

	解决办法,配置此bean
	* */
@Configuration
public class DeptServiceCallbackConfig {

   // @Bean
    public DeptServiceFallbackFactory getDeptServiceFallbackFactory(){
        return new DeptServiceFallbackFactory();
    }
}
