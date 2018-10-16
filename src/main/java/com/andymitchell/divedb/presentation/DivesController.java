package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.logic.Dive;
import com.andymitchell.divedb.logic.DivesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

}
