package ch.zli.nictus.timeTable.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TimetableSubject {

    @Id
    private long timetableId;

    @Id
    private long subjectId;

    public long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(long timetableId) {
        this.timetableId = timetableId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
}
