package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.enums.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDto {
    private String username;
    private String fullName;
    private Integer age;
    private Level level;

}
