package ch.zli.nictus.timeTable.dto;

import ch.zli.nictus.timeTable.model.SchoolClass;
import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.model.Timetable;
import ch.zli.nictus.timeTable.model.User;

import java.util.ArrayList;

public class UserDTO {

    private long userId;

    private SchoolClass schoolClass;

    private String username;

    private String password;

    public UserDTO(long userId, SchoolClass schoolClass, String username, String password) {
        this.userId = userId;
        this.schoolClass = schoolClass;
        this.username = username;
        this.password = password;
    }

    public UserDTO() { }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO toDTO(User user) {
        UserDTO newDto = new UserDTO();
        newDto.setUserId(user.getUserId());
        newDto.setSchoolClass(user.getSchoolClass());
        newDto.setUsername(user.getUsername());
        newDto.setPassword(user.getPassword());

        return newDto;
    }
}
