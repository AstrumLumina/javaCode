package com.xuanxie.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("日志:"+target.getClass().getName()+"执行了"+method.getName()+"方法");
    }
}
