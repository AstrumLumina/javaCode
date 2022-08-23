package com.xuanxie;

import com.xuanxie.AsyncService.MyEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsyncScheduEmailApplicationTests {
    @Autowired
    MyEmailService emailService;
    @Test
    void contextLoads() {
        //emailService.javaEmailService();
        emailService.MimeMessageEmail();
    }
}

