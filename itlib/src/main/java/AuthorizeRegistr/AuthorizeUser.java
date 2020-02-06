package AuthorizeRegistr;

import DbConn.DbConnection;
import models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizeUser {

    public boolean authorize(String login, String password){
        User user = getUserByLogin(login);
        if(user == null) return false;
        if(user.getPassword().equals(getEncryptionPassword(password))) {
            addToLogs(user, Status.OK.toString());
            return true;
        }
        else {
            addToLogs(user, Status.FAIL.toString());
            return false;
        }
    }
    public void addToLogs(User user, String status){
        String SQL = "insert into user_log (user_id, login_time, status) values (?, now(), ?)";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, user.getId());
            pstmt.setString(2,status);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private User getUserByLogin(String login){
        String SQL = "select * from users where login = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, login);
            try (ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getInt("role_id"),
                            rs.getTimestamp("date_of_registration"),
                            rs.getBoolean("is_active")
                    );
                    return user;
                }
                return null;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private String getEncryptionPassword(String password){
        String md5 = DigestUtils.md5Hex(password);
        return md5;
    }
}
