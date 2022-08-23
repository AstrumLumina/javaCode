package DbConnectPool;

import jdbctest.JdbcUtilsTool;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPutilsTool {
    private static DataSource datasource;
    static{
        try{
            InputStream in= JdbcUtilsTool.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties=new Properties();
            properties.load(in);
            //创建数据源
            datasource= BasicDataSourceFactory.createDataSource(properties);//工厂模式 创建
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public static Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }


}
