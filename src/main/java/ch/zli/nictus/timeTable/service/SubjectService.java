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
        Subject updatedSubject;
        Optional<Subject> optionalUpdatedEntry = findSubjectById(id);

        if (optionalUpdatedEntry.isPresent()) {
            updatedSubject = optionalUpdatedEntry.get();
            updatedSubject.setSubjectId(subject.getSubjectId());
            updatedSubject.setName(subject.getName());
            updatedSubject.setStartTime(subject.getStartTime());
            updatedSubject.setEndTime(subject.getEndTime());
            updatedSubject.setDay(subject.getDay());
        } else {
            updatedSubject = subject;
            updatedSubject.setSubjectId(id);
        }
        return subjectRepository.saveAndFlush(updatedSubject);
    }
}
