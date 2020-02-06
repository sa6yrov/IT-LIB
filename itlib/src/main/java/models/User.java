package models;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;
    private String email;
    private Integer role_id;
    private Timestamp date_of_registration;
    private boolean is_active;

    public User(String login, String password, String email, Timestamp date_of_registration, boolean is_active) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.date_of_registration = date_of_registration;
        this.is_active = is_active;
    }
}
