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

public class Administrator{
    private Integer id;
    private String fullName;
    private Date birthDate;
    private String phoneNumber;
    private Integer userId;

    public Administrator(String fullName, Date birthDate, String phoneNumber, Integer userId) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }
}
