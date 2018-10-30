package com.andymitchell.divedb.presentation.web.dives;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UpdateDiveController {
    private DivesService divesService;

    @Autowired
    public UpdateDiveController(DivesService divesService) {
        this.divesService = divesService;
    }

    @RequestMapping(value = "/update_id", method = RequestMethod.GET)
    public String updateDiveForm(@RequestParam(name = "id") String id, Model model) {
        Dive diveToUpdate = divesService.getDiveFromId(Integer.parseInt(id));
        model.addAttribute("diveToUpdate", diveToUpdate);
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("updatedDive", diveToUpdate);
        return "update_form";
    }

    @PostMapping("update_dive")
    public String updateDive(@ModelAttribute Dive dive, Model model) {
        Dive updatedDive = divesService.updateDiveFromId(dive.getId(),dive);
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("dive", updatedDive);
        return "update_complete";
    }
}