package com.xuanxie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuuiService6002 {
    public static void main(String[] args) {
        SpringApplication.run(ZuuiService6002.class);
    }
}
