package com.xuanxie;

import com.xuanxie.pojo.Dog;
import com.xuanxie.pojo.MyEmail;
import com.xuanxie.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spingboot01ApplicationTests {

    @Autowired
    private Person person;
    @Autowired
    private Dog dog;
    @Autowired
    private MyEmail email;

    //测试类
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
        System.out.println(email);
    }
}
