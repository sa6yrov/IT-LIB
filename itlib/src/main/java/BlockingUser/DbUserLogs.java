package BlockingUser;

import DbConn.DbConnection;
import models.UserLog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUserLogs {
    public List<UserLog> getUserLogs(){
        List<UserLog> listUserLogs = new ArrayList<>();
        String SQL = "select * from user_logs";
        try(Connection conn = DbConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)){
            while(rs.next()){
                UserLog userLog = new UserLog(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("login_time"),
                        rs.getString("status")
                );
                listUserLogs.add(userLog);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listUserLogs;
    }
}
