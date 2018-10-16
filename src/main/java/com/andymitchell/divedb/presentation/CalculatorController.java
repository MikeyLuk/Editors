package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.logic.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CalculatorController {

    @Resource
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "firstDiveDepthMeters", defaultValue = "0") double firstDiveDepthMeters,
                             @RequestParam(value = "firstDiveLengthMinutes", defaultValue = "0") int firstDiveLengthMinutes,
                             @RequestParam(value = "secondDiveDepthMeters", defaultValue = "0") double secondDiveDepthMeters,
                             @RequestParam(value = "secondDiveLengthMinutes", defaultValue = "0") int secondDiveLengthMinutes) {

        return  calculatorService.planDive(firstDiveDepthMeters, firstDiveLengthMinutes,
                secondDiveDepthMeters, secondDiveLengthMinutes);
    }
}
