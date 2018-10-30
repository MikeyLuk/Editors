package com.andymitchell.divedb.presentation.web.dives;


import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/dives")
public class DivesController {

    private DivesService divesService;

    @Autowired
    public DivesController(DivesService divesService) {
        this.divesService = divesService;
    }

    @GetMapping
    public String dives(Model model) {
        model.addAttribute("allDives", divesService.getAllDives());
        model.addAttribute("diveSearch", new Dive());
        return "dives";
    }
}
