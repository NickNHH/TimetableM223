package ch.zli.nictus.timeTable.service;

import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findSubjectById(long id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    public void deleteSubjectById(long id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
        }
    }

    public Subject updateSubject(Subject subject, long id) {
        Subject originalSubject = findSubjectById(id).get();
        originalSubject.updateSubject(subject);
        return subjectRepository.saveAndFlush(originalSubject);
    }
}
