package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.logic.Dive;
import com.andymitchell.divedb.logic.DivesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class DivesController {
    @Resource
    private DivesService divesService;

    @PostMapping ("logbook/dives/save")
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @GetMapping("logbook/dives/getAllDives")
    public List<Dive> dives () {
        return divesService.getAllDives();
    }

    @GetMapping("logbook/dives/getDiveFromDateAndLocation")
    public Dive getDiveFromDateAndLocation (@RequestParam(value ="date", defaultValue = "")String date,
                                            @RequestParam(value = "location", defaultValue = "")String location) {
        return divesService.getDiveFromDateAndLocation(LocalDate.parse(date),location);
    }
    @DeleteMapping("logbook/dives/deleteDiveFromDateAndLocation")
    public Dive deleteDiveFromDateAndLocation (@RequestParam(value ="date", defaultValue = "")String date,
                                            @RequestParam(value = "location", defaultValue = "")String location) {
        return divesService.deleteDiveFromDateAndLocation(LocalDate.parse(date),location);
    }
}
