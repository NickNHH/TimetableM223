package ch.zli.nictus.timeTable.service;

import ch.zli.nictus.timeTable.model.SchoolClass;
import ch.zli.nictus.timeTable.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {
    private SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAll();
    }
}
