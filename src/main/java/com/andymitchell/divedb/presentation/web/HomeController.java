package com.andymitchell.divedb.presentation.web;

import com.andymitchell.divedb.logic.dives.Dive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping()
public class HomeController {

    @GetMapping(value = {"home","/"})
    public String home(Model model) {
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("date", LocalDate.now());
        return "home";
    }
}
