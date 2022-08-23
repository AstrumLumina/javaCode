package com.xuanxie.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class Person {
//该注解如果设置了required为false,那么开属性可以为null
    @Autowired(required = false)
    private Cat cat;//优先按类型注入,其次按id注入
    // 使用注解还可以不编写set方法,只要该属性再ioc容器内


    //可以配合@Qualifier注解使用,指代更明确,减少歧义,
   // @Autowired
   // @Qualifier(value = "dog2")
    @Resource(name = "dog2")
    private Dog dog;
//还可以使用java自带的注解@Resource

    private String name;

    public Cat getCat() {
        return cat;
    }

    public Dog getDog() {
        return dog;
    }

    public String getName() {
        return name;
    }

    public void setCat(@Nullable Cat cat) {//该注解表示可以为null
        this.cat = cat;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Cat cat, Dog dog, String name) {
        this.cat = cat;
        this.dog = dog;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }
}
