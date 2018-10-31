package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logbook/dives")
public class DivesAPIController {
    @Resource
    private DivesService divesService;

    @Resource
    private AuthenticationService authenticationService;

    @PostMapping
    public Dive save(@RequestBody Dive dive,
                     @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.save(dive);
    }

    @GetMapping
    public List<Dive> dives(@RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.getAllDives();
    }

    @GetMapping("/{id}")
    public Dive getDiveById(@PathVariable("id") int id,
                            @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);

        return divesService.getDiveFromId(id);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getDivesFromDate(@PathVariable("date") String date,
                                       @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);

        return divesService.getDivesFromDate(LocalDate.parse(date));
    }

    @GetMapping("location/{location}")
    public List<Dive> getDivesFromLocation(@PathVariable("location") String location,
                                           @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);

        return divesService.getDivesFromLocation(location);
    }

    @GetMapping("/date/{date}/location/{location}")
    public List<Dive> getDivesFromDateAndLocation(@PathVariable("date") String date,
                                                  @PathVariable("location") String location,
                                                  @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);

        return divesService.getDivesFromDateAndLocation(LocalDate.parse(date), location);
    }

    @DeleteMapping
    public List<Dive> deleteAllDives(@RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.deleteAllDives();
    }

    @DeleteMapping("/{id}")
    public Dive deleteDiveById(@PathVariable("id") int id,
                               @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.deleteDiveFromId(id);
    }

    @PutMapping
    public List<Dive> updateMultipleDives(@RequestBody List<Dive> divesToUpdate,
                                          @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.updateMultipleDives(divesToUpdate);
    }

    @PutMapping("/{id}")
    public Dive updateDiveById(@PathVariable int id,
                               @RequestBody Dive dive,
                               @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return divesService.updateDiveFromId(id, dive);
    }
}
