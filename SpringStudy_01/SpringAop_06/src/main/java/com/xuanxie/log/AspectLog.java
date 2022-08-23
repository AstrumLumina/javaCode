package com.xuanxie.log;

public class AspectLog {
    public void beforeLogAspect(){
        System.out.println("方法执行前...");
    }
    public void afterLogAspect(){
        System.out.println("方法执行后...");
    }
}
