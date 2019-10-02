package ch.zli.nictus.timeTable.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schoolClassId;

    @OneToMany(mappedBy = "schoolClass")
    @Column(nullable = false)
    private List<Timetable> timetable;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<User> userList;

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public List<Timetable> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Timetable> timetable) {
        this.timetable = timetable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
