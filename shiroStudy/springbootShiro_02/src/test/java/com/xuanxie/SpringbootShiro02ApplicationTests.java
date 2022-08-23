package com.xuanxie;

import com.xuanxie.mapper.UserMapper;
import com.xuanxie.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiro02ApplicationTests {


    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println("==============================");
        System.out.println(userService.getUserById(3));
        System.out.println("=============================");
    }

}
