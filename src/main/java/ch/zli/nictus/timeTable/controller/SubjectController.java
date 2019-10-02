package ch.zli.nictus.timeTable.controller;

import ch.zli.nictus.timeTable.dto.SubjectDTO;
import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * Gets all already created subjects
     *
     * @return List of subject objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectDTO> getAllEntries() {
        List<Subject> subjects = subjectService.findAll();
        List<SubjectDTO> dtoList = new ArrayList<>();
        for(Subject subject : subjects){
            dtoList.add(SubjectDTO.toDTO(subject));
        }
        return dtoList;
    }

    /**
     * Creates a new subject
     *
     * @param subject a subject object you want to create
     * @return a subjectDTO of the created subject
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDTO createSubject(@Valid @RequestBody Subject subject) {
        return SubjectDTO.toDTO(subjectService.createSubject(subject));
    }

    /**
     * Deletes a subject
     *
     * @param id the id of the subject you want to delete
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
    }

    /**
     * Updates the data of a subject
     *
     * @param subject the updated data of a subject object you want to have
     * @param id the id of the subject you want to update
     * @return the updated subject
     */
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subject updateEntry(@Valid @RequestBody Subject subject, @PathVariable Long id) {
        return subjectService.updateSubject(subject, id);
    }
}
