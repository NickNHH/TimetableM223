package ch.zli.nictus.timeTable.controller;

import ch.zli.nictus.timeTable.dto.TimetableDTO;
import ch.zli.nictus.timeTable.model.Timetable;
import ch.zli.nictus.timeTable.service.TimetableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/timetables")
public class TimetableController {

    private TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    /**
     * Gets all already created timetables
     *
     * @return List of timetable objects
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TimetableDTO> getAllEntries() {
        List<Timetable> timetables = timetableService.findAll();
        List<TimetableDTO> dtoList = new ArrayList<>();
        for(Timetable timetable : timetables){
            dtoList.add(TimetableDTO.toDTO(timetable));
        }
        return dtoList;
    }
}
