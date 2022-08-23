package jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InjectAttack {

    public static void main(String[] args) {
        login(" 'or'1=1","111'or '1=1");//sql注入,盗取数据
    }
    public static void login(String username,String password){
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtilsTool.getConnection();
            st=conn.createStatement();
            String sql="select * from users where `name` ='"+username+"'and `password`='"+password+"'";
           // sql="select * from `users`";
            rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            JdbcUtilsTool.release(conn,st,rs);
        }

    }
}
