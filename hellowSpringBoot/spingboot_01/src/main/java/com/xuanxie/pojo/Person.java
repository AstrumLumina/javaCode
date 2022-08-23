package com.xuanxie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component

//从yaml中获取值注入
//@ConfigurationProperties(prefix = "person") //这里爆红不影响程序,可以通过添加一个依赖解决爆红

//也可以加载指定的properties文件用于注入值
@PropertySource(value = "classpath:application.properties")
public class Person {
    private Dog dog;
    @Value("${name}")
    private String name;
    private Integer age;
    private Boolean isHappy;
    private Date bithday;
    private List<Object> list;
    private Map<Object,Object> map;

    public Person(Dog dog, String name,
                  Integer age, Boolean isHappy,
                  Date bithday, List<Object> list,
                  Map<Object, Object> map) {
        this.dog = dog;
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.bithday = bithday;
        this.list = list;
        this.map = map;
    }

    public Person() {
    }

    public Dog getDog() {
        return dog;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getHappy() {
        return isHappy;
    }

    public Date getBithday() {
        return bithday;
    }

    public List<Object> getList() {
        return list;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHappy(Boolean happy) {
        isHappy = happy;
    }

    public void setBithday(Date bithday) {
        this.bithday = bithday;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isHappy=" + isHappy +
                ", bithday=" + bithday +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
