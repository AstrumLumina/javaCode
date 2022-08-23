package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PreSate2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=JdbcUtilsTool.getConnection();
            String sql="delete from users where `name`=?";
            st=  conn.prepareStatement(sql);//先预编译sql语句,不执行
            st.setString(1,"酷酷");
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtilsTool.release(conn,st,null);
        }
    }
}

