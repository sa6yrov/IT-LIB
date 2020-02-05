package models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;
    private String email;
    private Integer roleId;

    public User(String login, String password, String email, Integer roleId) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }
}
