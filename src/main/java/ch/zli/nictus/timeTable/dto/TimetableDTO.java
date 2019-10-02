package ch.zli.nictus.timeTable.dto;

import ch.zli.nictus.timeTable.model.SchoolClass;
import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.model.Timetable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimetableDTO {

    private long timeTableId;

    private List<Long> subjectList;

    private SchoolClass schoolClass;

    private Date validUntil;

    public TimetableDTO(long timeTableId, List<Long> subjectList, SchoolClass schoolClass, Date validUntil) {
        this.timeTableId = timeTableId;
        this.subjectList = subjectList;
        this.schoolClass = schoolClass;
        this.validUntil = validUntil;
    }

    public TimetableDTO() { }

    public long getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(long timeTableId) {
        this.timeTableId = timeTableId;
    }

    public List<Long> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Long> subjectList) {
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

    public static TimetableDTO toDTO(Timetable timetable) {
        TimetableDTO newDto = new TimetableDTO();
        newDto.setTimeTableId(timetable.getTimeTableId());
        newDto.setSchoolClass(timetable.getSchoolClass());
        newDto.setValidUntil(timetable.getValidUntil());

        if (timetable.getSubjectList() != null) {
            ArrayList<Long> subjects = new ArrayList<>();
            for (Subject subject : timetable.getSubjectList()) {
                subjects.add(subject.getSubjectId());
            }
            newDto.setSubjectList(subjects);
        }

        return newDto;
    }
}
