package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.CalculatorService;
import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorAPIController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "firstDiveDepthMeters", defaultValue = "0") double firstDiveDepthMeters,
                             @RequestParam(value = "firstDiveLengthMinutes", defaultValue = "0") int firstDiveLengthMinutes,
                             @RequestParam(value = "secondDiveDepthMeters", defaultValue = "0") double secondDiveDepthMeters,
                             @RequestParam(value = "secondDiveLengthMinutes", defaultValue = "0") int secondDiveLengthMinutes,
                             @RequestParam(value = "token") String token) {

        authenticationService.validateToken(token);

        return calculatorService.planDive(firstDiveDepthMeters, firstDiveLengthMinutes,
                secondDiveDepthMeters, secondDiveLengthMinutes);

    }
}
