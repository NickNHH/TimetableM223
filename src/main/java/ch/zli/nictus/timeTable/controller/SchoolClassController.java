package ch.zli.nictus.timeTable.controller;

import ch.zli.nictus.timeTable.dto.SchoolClassDTO;
import ch.zli.nictus.timeTable.dto.TimetableDTO;
import ch.zli.nictus.timeTable.model.SchoolClass;
import ch.zli.nictus.timeTable.model.Timetable;
import ch.zli.nictus.timeTable.service.SchoolClassService;
import ch.zli.nictus.timeTable.service.TimetableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/schoolClasses")
public class SchoolClassController {

    private SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    /**
     * Gets all already created schoolClasses
     *
     * @return List of schoolClass objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolClassDTO> getAllEntries() {
        List<SchoolClass> schoolClasses = schoolClassService.findAll();
        List<SchoolClassDTO> dtoList = new ArrayList<>();
        for(SchoolClass schoolClass : schoolClasses){
            dtoList.add(SchoolClassDTO.toDTO(schoolClass));
        }
        return dtoList;
    }
}
