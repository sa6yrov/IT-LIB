package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingStuff {
    private Integer id;
    private String stuff;

    public TrainingStuff(String stuff) {
        this.stuff = stuff;
    }
}
