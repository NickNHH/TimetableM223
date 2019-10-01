package ch.zli.nictus.timeTable.model;

import org.hibernate.annotations.Generated;

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
    private Date validUnitl;

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

    public Date getValidUnitl() {
        return validUnitl;
    }

    public void setValidUnitl(Date validUnitl) {
        this.validUnitl = validUnitl;
    }
}
