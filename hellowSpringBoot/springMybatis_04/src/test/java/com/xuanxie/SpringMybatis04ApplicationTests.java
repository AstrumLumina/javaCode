package com.xuanxie;

import com.xuanxie.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jnlp.UnavailableServiceException;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringMybatis04ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
        //mybatis测试
        System.out.println("========================================");
        System.out.println("userMapper==null"+userMapper==null);

    }


}
