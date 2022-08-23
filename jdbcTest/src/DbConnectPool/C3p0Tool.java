package DbConnectPool;
import  com.mchange.v2.c3p0.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0Tool {
    private static DataSource dataSource=null;
    static{
        //.xml配置文件不需要向properties 文件一样导入，会自动匹配 ，找到文件 并导入配置
        //方式一：配置文件写法 **********************
       // dataSource=new ComboPooledDataSource();//默认导入
        dataSource= new ComboPooledDataSource("mysql");//导入指定名字的配置

        //方式2： 代码版配置*******************不建议，且此处的已经包不支持这些方法
        //dataSource=new ComboPooledDataSource();
        /*
        dataSource.setDriverclass();
        dataSource.setPassword();
        dataSource.setUser();
        dataSource.setJdbcUrl();
        dataSource.setMaxPoolSize();
        dataSource.setMinPoolsize();
         */

    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
