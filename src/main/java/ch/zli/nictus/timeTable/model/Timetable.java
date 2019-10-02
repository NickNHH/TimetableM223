package ch.zli.nictus.timeTable.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timeTableId;

    @ManyToMany(mappedBy = "timetableList")
    @Column(nullable = false)
    private List<Subject> subjectList;

    @ManyToOne
    private SchoolClass schoolClass;

    @Column
    private Date validUntil;

    public long getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(long timeTableId) {
        this.timeTableId = timeTableId;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
