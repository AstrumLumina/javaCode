package com.xuanxie;

import com.xuanxie.AsyncService.MyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync  //开启异步支持
@SpringBootApplication
@EnableScheduling  //开启定时功能
public class AsyncScheduEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncScheduEmailApplication.class, args);
    }
}
