package com.xuanxie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//使用@component就不用再到xml文件中配置bean了

/* 再springmvc三层架构中 以下注解和@compoonent相同,使用不同的便于区分
*   @Repository   :Dao层
*   @Service      :service层
*   @Controller   :servlet层
* */
@Component
@Scope("prototype")
public class User {
    private String name;

    //使用该注解后就相当再 xml中配置了属性
    @Value("xuanxie")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
