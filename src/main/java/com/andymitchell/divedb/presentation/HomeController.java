package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.logic.dives.Dive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping()
public class HomeController {
    @GetMapping
    public String base(Model model) {
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("date", LocalDate.now());
        return "home";
    }
    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("diveSearch", new Dive());
        model.addAttribute("date", LocalDate.now());
        return "home";
    }
    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("diveSearch", new Dive());
        return "login";
    }
}
