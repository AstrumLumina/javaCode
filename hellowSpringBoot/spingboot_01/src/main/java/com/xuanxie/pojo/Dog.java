package com.xuanxie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {
    private String dogName;
    private int age;
    private  String sex;

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Dog(String dogName, int age, String sex) {
        this.dogName = dogName;
        this.age = age;
        this.sex = sex;
    }

    public String getDogName() {
        return dogName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
