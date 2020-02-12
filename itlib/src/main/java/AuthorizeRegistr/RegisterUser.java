package AuthorizeRegistr;

import DbConn.DbConnection;
import models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {
    public boolean register(User user) {
        String SQL = "insert into users (login, password, email, role_id, date_of_registration, is_active) values (?, ?, ?, ?, now(), ?)";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, getEncryptionPassword(user.getPassword()));
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, 3);
            pstmt.setBoolean(5, true);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    private String getEncryptionPassword(String password){
        String md5 = DigestUtils.md5Hex(password);
        return md5;
    }
}
