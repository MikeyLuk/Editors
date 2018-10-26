package com.andymitchell.divedb.presentation.web;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class SearchController {

    private DivesService divesService;

    @Autowired
    public SearchController(DivesService divesService) {
        this.divesService = divesService;
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Dive dive, Model model) {
        model.addAttribute("allDives", divesService.getDivesFromLocation(dive.getLocation()));
        model.addAttribute("diveSearch", new Dive());
        return "dives";
    }
}


