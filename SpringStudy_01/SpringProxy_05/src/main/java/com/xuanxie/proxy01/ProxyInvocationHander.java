package com.xuanxie.proxy01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//这个类实现一个接口调用,用于被调用代理对象的方法,还可以加入一些自己的操作
//Proxy有一个静态方法可以放回代理对象
public class ProxyInvocationHander implements InvocationHandler {

    //处理代理实例,并放回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //添加一些代理操作
        log(method.getName());
        //执行被代理对象的方法
        Object result = method.invoke(target, args);
        return result;
    }

    //我们可以添加一些方法便于使用
    private Object target;
    public ProxyInvocationHander setTarget(Object target){
        this.target=target;
        return this;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    public void log(String msg){
        System.out.println("[日志]:"+"执行了 "+msg+" 方法 ");
    }
}
