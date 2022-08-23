package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcLogin {
    public static void main(String[] args) {
        securelogin("lisi","123456");
        securelogin("'or'1=1","123456");//此时出入无效,不报错也无输出
        //本质,将所有的输入视为字符,对于转义字符会直接转义
    }
    public  static void securelogin(String  name,String password){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=JdbcUtilsTool.getConnection();
            String sql="select * from users where `name` =? and `password`=?";
            st=conn.prepareStatement(sql);
            st.setString(1,name);
            st.setString(2,password);
            rs=st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtilsTool.release(conn,st,rs);
        }
    }

}
