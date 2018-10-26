package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import com.andymitchell.divedb.logic.statistics.StatisticsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/statistics")
public class StatisticsAPIController {

    @Resource
    private StatisticsService statisticsService;

    @GetMapping
    public DiveStatistic getDiveStatistic() {
        return statisticsService.getDiveStatistic();
    }

}
