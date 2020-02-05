package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mentor {
    private Integer id;
    private String fullName;
    private Date birthDate;
    private String phone_number;
    private Integer userId;

    public Mentor(String fullName, Date birthDate, String phone_number, Integer userId) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.userId = userId;
    }
}
