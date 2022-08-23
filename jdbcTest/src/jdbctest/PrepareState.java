package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PrepareState {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=JdbcUtilsTool.getConnection();
            String sql="insert into users(`id`,`name`,`password`,`email`,`birthday`) " +
                    "values(?,?,?,?,?)";
            st=  conn.prepareStatement(sql);//先预编译sql语句,不执行
            //可以防止sql注入

            //手动设置参数
            st.setInt(1,7);
            st.setString(3,"123456");
            st.setString(2,"雄安");
            st.setString(4,"3423@qq.com");
            st.setDate(5,new java.sql.Date(new Date().getTime()));
            //执行
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
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