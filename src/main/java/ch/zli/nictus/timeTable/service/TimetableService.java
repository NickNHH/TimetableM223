package ch.zli.nictus.timeTable.service;

import ch.zli.nictus.timeTable.model.Timetable;
import ch.zli.nictus.timeTable.repository.TimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    private TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }
}
