package com.xuanxie.providerserve.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService  //注意时dubbo中的Service注解  ,将服务发布出去
                //新版@service过时,不可用
@Component  //放到容器里
public class MyServiceImpl implements MyService {
    @Override
    public String serviceTest() {
        return "dubbo+zookeeper测试";
    }
}
