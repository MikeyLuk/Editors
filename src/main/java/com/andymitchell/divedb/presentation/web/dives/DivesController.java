package com.andymitchell.divedb.presentation.web.dives;


import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/dives")
public class DivesController {

    private DivesService divesService;

    @Autowired
    public DivesController(DivesService divesService) {
        this.divesService = divesService;
    }

    @GetMapping("/dives")
    public String dives(Model model) {
        model.addAttribute("allDives", divesService.getAllDives());
        model.addAttribute("diveSearch", new Dive());
        return "dives";
    }

    @RequestMapping(value = "/delete_id", method = RequestMethod.GET)
    public String deleteDive(@RequestParam(name = "id") String id, Model model) {
        Dive deletedDive = divesService.deleteDiveFromId(Integer.parseInt(id));
        model.addAttribute("dive", deletedDive);
        model.addAttribute("diveSearch", new Dive());
        return "delete_complete";
    }

    @GetMapping("/create_dive")
    public String createDive(Model model) {
        model.addAttribute("dive", new Dive());
        model.addAttribute("diveSearch", new Dive());
        return "create_dive";
    }

    @PostMapping("/create_dive")
    public String submitDive(@ModelAttribute Dive dive, Model model) {
        Dive savedDive = divesService.save(dive);
        model.addAttribute("dive", savedDive);
        model.addAttribute("diveSearch", new Dive());
        return "create_complete";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Dive dive, Model model) {
        model.addAttribute("allDives", divesService.getDivesFromLocation(dive.getLocation()));
        model.addAttribute("diveSearch", new Dive());
        return "dives";
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
