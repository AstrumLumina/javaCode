package com.xuanxie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer  //开启提供配置服务
public class ConfigService6003 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigService6003.class);
    }
}

/*
/{application}/{profile}[/{label}]   		//	http://localhost:3344/application/test/master
/{application}-{profile}.yml				//	http://localhost:3344/application-test.yml
/{label}/{application}-{profile}.yml		//	http://localhost:3344/master/application-test.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
* */