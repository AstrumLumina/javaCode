package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionTest {
    public static void main(String[] args) throws SQLException {
        Connection conn =null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=JdbcUtilsTool.getConnection();
            //关闭自动提交，开始事物
            conn.setAutoCommit(false);
            String sql="select * from users";
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("id"));
            }
            sql=" insert into users(`id`,`name`) values(12,'小嗨')";
            st=conn.prepareStatement(sql);
            st.executeUpdate();
            //制造错误，然事物不能正常完成
            int a=10/0;

            sql="insert into users(`id`,`name`) values(6,'酷')";
            st=conn.prepareStatement(sql);
            st.executeUpdate();
            //业务完成，提交事务
            conn.commit();
            System.out.println("事物成功");
        }
        catch (SQLException e) {
            //即使设置回滚，也会自动回滚
//            try{
//                conn.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();

        }finally{
            //观察事物出错回滚的情况
            String sql="select * from users";
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("id"));
            }
           // conn.commit();
            JdbcUtilsTool.release(conn,st,rs);
        }
    }
}
