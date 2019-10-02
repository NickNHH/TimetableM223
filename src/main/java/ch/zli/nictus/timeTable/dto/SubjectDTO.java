package ch.zli.nictus.timeTable.dto;

import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.model.Timetable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectDTO {
    private long subjectId;

    private String name;

    private Date startTime;

    private Date endTime;

    private String day;

    private List<Long> timetableList;

    public SubjectDTO(long subjectId, String name, Date startTime, Date endTime, String day, List<Long> timetableList) {
        this.subjectId = subjectId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.timetableList = timetableList;
    }

    public SubjectDTO() { }

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

    public List<Long> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Long> timetableList) {
        this.timetableList = timetableList;
    }

    public static SubjectDTO toDTO(Subject subject) {
        SubjectDTO newDto = new SubjectDTO();
        newDto.setSubjectId(subject.getSubjectId());
        newDto.setName(subject.getName());
        newDto.setStartTime(subject.getStartTime());
        newDto.setEndTime(subject.getEndTime());
        newDto.setDay(subject.getDay());

        if (subject.getTimetableList() != null) {
            ArrayList<Long> timetables = new ArrayList<>();
            for (Timetable timetable : subject.getTimetableList()) {
                timetables.add(timetable.getTimeTableId());
            }
            newDto.setTimetableList(timetables);
        }

        return newDto;
    }
}
