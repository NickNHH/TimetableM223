package ch.zli.nictus.timeTable.dto;

import ch.zli.nictus.timeTable.model.SchoolClass;
import ch.zli.nictus.timeTable.model.Timetable;
import ch.zli.nictus.timeTable.model.User;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassDTO {

    private long schoolClassId;

    private List<Long> timetableList;

    private String name;

    private List<Long> userList;

    public SchoolClassDTO(long schoolClassId, String name, List<Long> timetableList, List<Long> userList) {
        this.schoolClassId = schoolClassId;
        this.name = name;
        this.timetableList = timetableList;
        this.userList = userList;
    }

    public SchoolClassDTO() {
    }

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public List<Long> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Long> timetableList) {
        this.timetableList = timetableList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

    public static SchoolClassDTO toDTO(SchoolClass schoolClass) {
        SchoolClassDTO newDto = new SchoolClassDTO();
        newDto.setSchoolClassId(schoolClass.getSchoolClassId());
        newDto.setName(schoolClass.getName());

        if (schoolClass.getTimetableList() != null) {
            ArrayList<Long> timetables = new ArrayList<>();
            for (Timetable timetable : schoolClass.getTimetableList()) {
                timetables.add(timetable.getTimeTableId());
            }
            newDto.setTimetableList(timetables);
        }

        if (schoolClass.getUserList() != null) {
            ArrayList<Long> users = new ArrayList<>();
            for (User user : schoolClass.getUserList()) {
                users.add(user.getUserId());
            }
            newDto.setUserList(users);
        }

        return newDto;
    }
}
