package com.andymitchell.divedb.logic.statistics;

import com.andymitchell.divedb.logic.dives.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatisticsService {
    @Resource
    private DivesService divesService;

    @Autowired
    public StatisticsService(DivesService divesService) {
        this.divesService = divesService;
    }

    public DiveStatistic getDiveStatistic () {
        return divesService.getDiveStatistic();
    }

}
