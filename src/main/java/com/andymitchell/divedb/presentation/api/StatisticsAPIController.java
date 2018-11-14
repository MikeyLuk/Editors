package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import com.andymitchell.divedb.logic.statistics.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsAPIController {

    @Resource
    private StatisticsService statisticsService;

    @Resource
    private AuthenticationService authenticationService;

    @GetMapping
    public DiveStatistic getDiveStatistic(@RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);
        return statisticsService.getDiveStatistic(authenticationService.getUserIdFromToken(token));
    }

}
