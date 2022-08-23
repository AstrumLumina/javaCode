package com.xuanxie.consumerserve;

import com.xuanxie.service.GetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServeApplicationTests {

    @Autowired
    GetService getService;
    @Test
    void contextLoads() {
        System.out.println(getService.consumerGetService());
    }

}
