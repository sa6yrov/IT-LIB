package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserLog {
    private Integer id;
    private Integer userId;
    private Timestamp loginTime;
    private String status;

    public UserLog(Integer userId, Timestamp loginTime, String status) {
        this.userId = userId;
        this.loginTime = loginTime;
        this.status = status;
    }
}

