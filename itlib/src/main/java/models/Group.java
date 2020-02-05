package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Group {
    private Integer id;
    private String inn;
    private Integer courseId;
    private Integer mentorId;

    public Group(String inn, Integer courseId, Integer mentorId) {
        this.inn = inn;
        this.courseId = courseId;
        this.mentorId = mentorId;
    }
}
