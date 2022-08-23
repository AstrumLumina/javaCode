package jdbctest;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcTest1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动  固定写法
        Class.forName("com.mysql.jdbc.Driver");
          //写法2:
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//初始化了两次

        //2,用户信息url
       // useUnicode=true&characterEncoding=utf8&useSSL=true
        String url="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        //           协议      ://主机地址:端口号/数据库名?参数1&参数2&...
        //cracle --默认端口号1521  写法: jdbc:oracle:thin:@localhost:1521:sid
        String username="root";
        String password="123456";

        //3.连接成功
        Connection connection =DriverManager.getConnection(url,username,password);
        //connection代表数据库对象,可执行数据库能经行的操作

        //4.执行sql的对象
        Statement statement=connection.createStatement();
        /*
        statement.executeQuery();//查询操作
        statement.execute();//执行任何操作
        statement.executeUpdate();//执行 删除,插入,更新
         */

        //5.执行sql的对象 去执行sql语句,可能有结果
        String sql="SELECT * FROM users";//sql语句
        ResultSet resultset =statement.executeQuery(sql);//返回结果集,是链表的形式,封装了全部的值
       //statement实质是向数据库发送sql语句,返回一个整数(受影响的行数
        while(resultset.next()){
            System.out.println("*************************");
            System.out.println("id: " + resultset.getObject("id"));
            System.out.println("name: " + resultset.getObject("name"));
            System.out.println("pwd: " + resultset.getObject("password"));
            System.out.println("email: " + resultset.getObject("email"));
            System.out.println("birth: " + resultset.getObject("birthday"));
        }
        //Result返回所有的结果集
        /*
        resultset.getInt();
        resultset.getString();
        resultset.getObject();//用于不知道类型是获取任意类型的结果
         */
        //指针移动,以输出想要的结果
        resultset.beforeFirst();//移动大最前面
        resultset.afterLast();//末尾
        resultset.next();//下一条
        resultset.previous();//前一条
        resultset.absolute(2);//移动到指定行


        //6.释放连接  后开先断
        resultset.close();
        statement.close();
        connection.close();
    //可以封装以简化代码

    }
}
