package DbConn;

import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDb {
    public void addStudentToDb(Student student){
        String SQL = "insert into (full_name, birth_date, inn, phone_number, group_id, user_id) values(?, ?, ?, ?, ?, ?)";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, student.getFullName());
            pstmt.setDate(2, student.getBirthDate());
            pstmt.setString(3, student.getInn());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setInt(5, student.getGroupId());
            pstmt.setInt(6, student.getUserId());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
