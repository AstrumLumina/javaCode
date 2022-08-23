package com.xuanxie.springdata_03;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringData03ApplicationTests {

    //spingboot自动帮我们配置的对象
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源
        System.out.println(dataSource.getClass());//class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource);

        //测试连接
        Connection connection = dataSource.getConnection();
       // System.out.println(connection);

            //测试druid数据源
            DruidDataSource druidDataSource= (DruidDataSource) dataSource;
            System.out.println("druidDataSource 数据源的最大连接数: "+druidDataSource.getMaxActive());
            System.out.println("druidDataSource 数据源的初始化连接数: "+druidDataSource.getInitialSize());



        //关闭连接
        connection.close();


    }

}
