package ch.zli.nictus.timeTable.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    @Column(nullable = false)
    private String name;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column(nullable = false)
    private String day;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @Column(nullable = false)
    private List<Timetable> timetableList;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    public void updateSubject(Subject newSubject) {
        if (newSubject.getName() != null) {
            this.setName(newSubject.getName());
        }
        if (newSubject.getStartTime() != null) {
            this.setStartTime(newSubject.getStartTime());
        }
        if (newSubject.getEndTime() != null) {
            this.setEndTime(newSubject.getEndTime());
        }
        if (newSubject.getDay() != null) {
            this.setDay(newSubject.getDay());
        }
        if (newSubject.getTimetableList() != null) {
            this.setTimetableList(newSubject.getTimetableList());
        }
    }
}
