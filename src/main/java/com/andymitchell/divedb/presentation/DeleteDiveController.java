package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class DeleteDiveController {
    private DivesService divesService;

    @Autowired
    public DeleteDiveController(DivesService divesService) {
        this.divesService = divesService;
    }

    @RequestMapping(value = "/delete_id", method = RequestMethod.GET)
    public String deleteDive(@RequestParam(name = "id") String id, Model model) {
        Dive deletedDive = divesService.deleteDiveFromId(Integer.parseInt(id));
        model.addAttribute("dive", deletedDive);
        return "delete_complete";
    }
}