package com.xuanxie.webjdbc;

import  org.junit.Test;
import java.sql.*;


public class Transaction {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        //配置信息
        String url="jdbc:mysql://localhost:3306/jdbc?" +
                "useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        Connection connection=null;
        try{
            //1.加载 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.registerDriver(new Driver());//写法二,不推荐
            //2.连接数据库
            connection = DriverManager.getConnection(url, username, password);

            //开启事物
            connection.setAutoCommit(false);
            String sql2 = "update account set money=money+100 where name='A';";
            String sql1="update account set money=money-100 where name='B';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            //模拟出现错误,自动回滚,事物无效
            int temp=1/0;

            //提交事物 若以上都没有问题,则可以提交事物
            connection.commit();
        }catch(Exception e){
            e.printStackTrace();
            //也可手动回滚
            if(connection!=null){
                try{
                    connection.rollback();
                }catch (SQLException e2){
                    e2.printStackTrace();;
                }
            }
        }finally{
            if(connection!=null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();;
                }
            }
        }
    }

}
