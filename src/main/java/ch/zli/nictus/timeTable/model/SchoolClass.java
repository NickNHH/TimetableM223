package ch.zli.nictus.timeTable.model;

import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schoolClassId;

    @Column(nullable = false)
    private long timetable;

    @Column(nullable = false)
    private String name;

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public long getTimetable() {
        return timetable;
    }

    public void setTimetable(long timetable) {
        this.timetable = timetable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
