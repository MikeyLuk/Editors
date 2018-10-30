package com.andymitchell.divedb.presentation.web.dives;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create_dive")
public class CreateDiveController {
    private DivesService divesService;

    @Autowired
    public CreateDiveController(DivesService divesService) {
        this.divesService = divesService;
    }

    @GetMapping
    public String dives(Model model) {
        model.addAttribute("dive", new Dive());
        model.addAttribute("diveSearch", new Dive());
        return "create_dive";
    }

    @PostMapping
    public String addDive(@ModelAttribute Dive dive, Model model) {
        Dive savedDive = divesService.save(dive);
        model.addAttribute("dive", savedDive);
        model.addAttribute("diveSearch", new Dive());
        return "create_complete";
    }
}
