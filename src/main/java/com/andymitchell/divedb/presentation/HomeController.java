package com.andymitchell.divedb.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("date", LocalDate.now());
        return "home";
    }
}
