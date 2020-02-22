package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StuffForGroup {
    private Integer id;
    private Integer trainingStuffId;
    private Integer groupId;

    public StuffForGroup(Integer trainingStuffId, Integer groupId) {
        this.trainingStuffId = trainingStuffId;
        this.groupId = groupId;
    }
}
