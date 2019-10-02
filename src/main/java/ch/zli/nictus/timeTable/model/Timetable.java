package ch.zli.nictus.timeTable.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timeTableId;

    @Column(nullable = false)
    private long subject;

    @Column
    private Date validUntil;

    public long getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(long timeTableId) {
        this.timeTableId = timeTableId;
    }

    public long getSubject() {
        return subject;
    }

    public void setSubject(long subject) {
        this.subject = subject;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}
