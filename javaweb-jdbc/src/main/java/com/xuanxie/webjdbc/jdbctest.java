package com.xuanxie.webjdbc;

import java.sql.*;

public class jdbctest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url="jdbc:mysql://localhost:3306/jdbc?" +
                "useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";

        //1.加载 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // DriverManager.registerDriver(new Driver());//写法二,不推荐
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //connection代表数据库
        //3.向数据库发送sql语句的对象 statement:crud
        Statement statement = connection.createStatement();
           //安全方法: PreparedStatement preparedStatement = connection.prepareStatement();
        //4.编写sql 语句
        String sql="select * from users;";//要不要分号都可以
       // String sql2="delete from users where id=4";

        //5.执行sql
        ResultSet rs = statement.executeQuery(sql);
      //  int count=statement.executeUpdate(sql2);//返回变化的行数
      //  System.out.println("有"+count+"行变化了");
        /*
        * 一个stmt多个rs进行操作.那么从stmt得到的rs1,
        * 必须马上操作此rs1后,才能去得到另外的rs2,再对rs2操作.
        * 不能互相交替使用,会引起rs已经关闭错误.错误的代码如下:
        * 以上写法先获取rs,但未输出,又执行了sql2导致rs被自动关闭,无法输出
        * */

        System.out.println("===============");
        if(rs!=null){
            while(rs.next()){
                System.out.println("id= " + rs.getObject("id"));
                System.out.println("name= " + rs.getObject("name"));
                System.out.println("email= " + rs.getObject("email"));
                System.out.println("password= " + rs.getObject("password"));
                System.out.println("birthday= " + rs.getObject("birthday"));
                System.out.println("=========================");
            }
        }else{
            System.out.println("未查询到东西!!!!");
        }

        //查询**************************************************
         String sql2="delete from users where id=4";
          int count=statement.executeUpdate(sql2);//返回变化的行数
          System.out.println("有"+count+"行变化了");

         //安全写法:可以防止sql注入问题
        //3.加载驱动,获得connect后 编写sql
        String sql3="insert into users(id,`name`,email,birthday,password) values(?,?,?,?,?);";
        //4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        //5.赋值
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"王五");
        preparedStatement.setDate(4,new Date(new java.util.Date().getTime()));
        preparedStatement.setString(3,"wwu@qq.com");
        preparedStatement.setString(5,"123456");
        //6.提交执行sql
        int count2 =preparedStatement.executeUpdate();
        if(count2>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }

        //关闭连接
        rs.close();
        statement.close();
        connection.close();
    }
}
