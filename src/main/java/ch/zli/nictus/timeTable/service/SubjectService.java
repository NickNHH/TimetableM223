package ch.zli.nictus.timeTable.service;

import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    public void deleteSubjectById(long id) {
        //TODO: Add delete method
    }

    public Subject updateSubject(Subject subject, long id) {
        //TODO: Add update method
        return null;
    }
}
