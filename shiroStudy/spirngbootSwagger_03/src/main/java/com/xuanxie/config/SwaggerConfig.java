package com.xuanxie.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/*
* swagger2  3.0版本的访问路径 /swagger-ui/index.html
  swagger2 3.0一下版本访问路径 /swagger-ui.html
* */

@Api(tags = "swagger2注解学习使用模块")
@Configuration   //将配置注入到容器中
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    //默认duocker
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2);
    }

    //*********************************************************************

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    @Bean   //参考docker
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("分组,多个docker不能同组名");
    }

//*****************************************************
    private ApiInfo apiInfo2(){
        Contact xuanxie = new Contact("xuanxie", "localhost:8080", "325884@whut.edu.cn");
        ApiInfo apiInfo = new ApiInfo("spirngboot_swagger项目开发文档"
                , "学习使用swagger"
                , "version1.0"
                , "local host:8080"
                , xuanxie
                , "国家许可"
                , "localhost:8080"
                , new ArrayList<>());
        return apiInfo;
    }
    @Bean  //构建自己的duocker
    public Docket docket(Environment environment) {//接收环境与运行是环境
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean isTest = environment.acceptsProfiles(of);//如果是开发环境,即test或者dev,则开启swagger

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A组")//设置文档组
                .enable(isTest)//开启api文档功能,可以更具开发环境决定是否开启
                .apiInfo(apiInfo2())
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.xuanxie.controller"))
                //regex(final String pathRegex) // 通过正则表达式控制
                //ant(final String antPattern) // 通过ant()控制
                .build();
    }
}
