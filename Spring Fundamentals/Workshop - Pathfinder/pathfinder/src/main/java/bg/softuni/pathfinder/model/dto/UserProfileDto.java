package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.enums.Level;

public class UserProfileDto {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private String username;
    private String fullName;
    private Integer age;
    private Level level;

    public UserProfileDto() {
    }


}
