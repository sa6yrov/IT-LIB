package BlockingUser;

import AuthorizeRegistr.Status;
import DbConn.DbConnection;
import models.UserLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlockingUser {
    public boolean blockingUser(List<UserLog> userLogList){
        for (UserLog ul : userLogList) {
            if(checkStatusUsers(ul)){
                String SQL = "update users set is_active = ? where id = ?";
                try(Connection conn = DbConnection.connect();
                    PreparedStatement pstmt = conn.prepareStatement(SQL)){
                        pstmt.setBoolean(1, false);
                        pstmt.setInt(2, ul.getUserId());
                        pstmt.executeUpdate();
                        return true;
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }
    public boolean checkStatusUsers(UserLog userLog){
        int count = 0;
        String SQL = "select count(*) from user_logs where user_id = ? and status = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, userLog.getUserId());
            pstmt.setString(2, Status.FAIL.toString());
            try(ResultSet rs = pstmt.executeQuery()){
                rs.next();
                count = rs.getInt(1);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(count >= 5) return true;
        return false;
    }
}
