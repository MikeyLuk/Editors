package com.andymitchell.divedb.presentation.web.dives;


import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import com.andymitchell.divedb.logic.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class DivesController {

    private DivesService divesService;
    private UserService userService;

    @Autowired
    public DivesController(DivesService divesService, UserService userService) {
        this.divesService = divesService;
        this.userService = userService;
    }

    @GetMapping("/dives")
    public String dives(Model model) {
        model.addAttribute("allDives", divesService.getAllDives(getCurrentUserId()));
        model.addAttribute("diveSearch", new Dive());
        return "dives";
    }

    @RequestMapping(value = "/delete_id", method = RequestMethod.GET)
    public String deleteDive(@RequestParam(name = "id") String id, Model model) {
        Dive deletedDive = divesService.deleteDiveFromId(Integer.parseInt(id), getCurrentUserId());
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
        Dive savedDive = divesService.save(dive, getCurrentUserId());
        model.addAttribute("dive", savedDive);
        model.addAttribute("diveSearch", new Dive());
        return "create_complete";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Dive dive, Model model) {
        model.addAttribute("allDives", divesService.getDivesFromLocation(dive.getLocation(), getCurrentUserId()));
        model.addAttribute("diveSearch", new Dive());
        return "dives";
    }

    @RequestMapping(value = "/update_id", method = RequestMethod.GET)
    public String updateDiveForm(@RequestParam(name = "id") String id, Model model) {
        Dive diveToUpdate = divesService.getDiveFromId(Integer.parseInt(id), getCurrentUserId());
        model.addAttribute("diveToUpdate", diveToUpdate);
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("updatedDive", diveToUpdate);
        return "update_form";
    }

    @PostMapping("update_dive")
    public String updateDive(@ModelAttribute Dive dive, Model model) {
        Dive updatedDive = divesService.updateDiveFromId(dive.getId(),dive, getCurrentUserId());
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("dive", updatedDive);
        return "update_complete";
    }

    private Integer getCurrentUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return userService.findUserByEmail(currentUserName).getId();
        }
        return null;
    }
}
