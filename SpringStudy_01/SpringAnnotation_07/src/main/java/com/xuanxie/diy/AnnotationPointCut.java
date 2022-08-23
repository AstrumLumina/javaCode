package com.xuanxie.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//使用注解将其标志为切面
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.xuanxie.service.UserService.*(..))")
    public void before(){
        System.out.println("注解before");
    }
    @After("execution(* com.xuanxie.service.UserService.*(..))")
    public void after(){
        System.out.println("注解after");

    }

    @Around("execution(* com.xuanxie.service.UserService.*(..))")
    public void round(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("方法执行前");
        System.out.println(pj.getSignature());
        Object proceed = pj.proceed();//这样可以使原来的方法无效,注释掉;或者执行多次

        System.out.println("方法执行后");
    }

}
