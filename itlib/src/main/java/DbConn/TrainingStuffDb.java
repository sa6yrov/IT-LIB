package DbConn;

import models.TrainingStuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingStuffDb {
    public TrainingStuff getStuffById(Integer id){
        TrainingStuff trainingStuff = null;
        String SQL = "select * from training_stuff where id = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    trainingStuff = new TrainingStuff(rs.getString("stuff"));
                    return trainingStuff;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
