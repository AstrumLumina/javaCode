package com.xuanxie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuanxie.mapper")
public class SpringMybatis04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatis04Application.class, args);
    }

}
