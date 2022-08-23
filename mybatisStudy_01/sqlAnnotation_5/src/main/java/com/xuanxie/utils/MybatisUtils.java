package com.xuanxie.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory  工具类  用来构造sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    static {
        try {
            //获取sqlSession对象
            String resource="mybatis-config.xml";/*放在resources 目录下时,可以可以直接写文件名,以简化*/
            InputStream resourceInPutStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceInPutStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  SqlSession getSqlSession(boolean authCommit){
        return sqlSessionFactory.openSession(authCommit);//设置是否自动提交事物
    }

}
