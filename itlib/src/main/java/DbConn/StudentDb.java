package DbConn;

import models.Student;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDb {
    public boolean addStudentToDb(Student student){
        String SQL = "insert into students (full_name, birth_date, gender, inn, phone_number, group_id, user_id) values(?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, student.getFullName());
            pstmt.setString(2, student.getBirthDate());
            pstmt.setString(3, student.getGender());
            pstmt.setString(4, student.getInn());
            pstmt.setString(5, student.getPhoneNumber());
            pstmt.setInt(6, student.getGroupId());
            pstmt.setInt(7, student.getUserId());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Integer getUserId(String login){
        String SQL = "select id from users where login = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, login);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()) return rs.getInt("id");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
