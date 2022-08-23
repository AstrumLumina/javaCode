package com.xuanxie.service;

import com.xuanxie.providerserve.service.MyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class GetService {

    @DubboReference  //会按照全类名进行匹配,
    // 看谁给注册中心注册了这个全类名,因此需要保证包名和类名与服务提供者一致
    MyService myService;

    public String consumerGetService(){
        return myService.serviceTest();
    }
}
