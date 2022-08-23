package jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static jdbctest.JdbcUtilsTool.*;

public class InsertTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement=null;
        ResultSet resultset=null;
        try {
            connection = JdbcUtilsTool.getConnection();
            statement=connection.createStatement();
            String sql="insert into users(`id`,`name`,`password`,`email`,`birthday`)" + " values(6,'酷酷','123456','kuku@com','2000-01-01')";
            int i=statement.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(connection,statement,resultset);
        }
    }

}
