package DbConnectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0test {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn=C3p0Tool.getConnection();
            String sql="select * from users";
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            DBCPutilsTool.release(conn,st,rs);
        }


    }

}
