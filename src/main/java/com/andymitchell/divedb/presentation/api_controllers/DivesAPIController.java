package com.andymitchell.divedb.presentation.api_controllers;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/logbook/dives")
public class DivesAPIController {
    @Resource
    private DivesService divesService;

    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @GetMapping
    public List<Dive> dives() {
        return divesService.getAllDives();
    }

    @GetMapping("/{id}")
    public Dive getDiveById(@PathVariable("id") int id) {
        return divesService.getDiveFromId(id);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getDivesFromDate(@PathVariable("date") String date) {
        return divesService.getDivesFromDate(LocalDate.parse(date));
    }

    @GetMapping("location/{location}")
    public List<Dive> getDivesFromLocation(@PathVariable("location") String location) {
        return divesService.getDivesFromLocation(location);
    }

    @GetMapping("/date/{date}/location/{location}")
    public List<Dive> getDivesFromDateAndLocation(@PathVariable("date") String date,
                                                  @PathVariable("location") String location) {
        return divesService.getDivesFromDateAndLocation(LocalDate.parse(date), location);
    }

    @DeleteMapping
    public List<Dive> deleteAllDives() {
        return divesService.deleteAllDives();
    }

    @DeleteMapping("/{id}")
    public Dive deleteDiveById(@PathVariable("id") int id) {
        return divesService.deleteDiveFromId(id);
    }

    @PutMapping
    public List<Dive> updateMultipleDives(@RequestBody List<Dive> divesToUpdate) {
        return divesService.updateMultipleDives(divesToUpdate);
    }

    @PutMapping("/{id}")
    public Dive updateDiveById(@PathVariable int id,
                               @RequestBody Dive dive) {
        return divesService.updateDiveFromId(id, dive);
    }
}
