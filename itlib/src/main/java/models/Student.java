package models;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private Integer id;
    private String fullName;
    private Date birthDate;
    private String inn;
    private String phoneNumber;
    private Integer groupId;
    private Integer userId;

    public Student(String fullName, Date birthDate, String inn, String phoneNumber, Integer groupId, Integer userId) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.inn = inn;
        this.phoneNumber = phoneNumber;
        this.groupId = groupId;
        this.userId = userId;
    }
}
