package com.andymitchell.divedb.data;

import com.andymitchell.divedb.logic.DiveStatistic;

import java.util.List;

import com.andymitchell.divedb.logic.StatisticUtils;

import static com.andymitchell.divedb.logic.StatisticUtils.*;

public class StatisticMapper {
    public static DiveStatistic mapToDiveStatistic (int totalNumberOfDives,
                                                    List<Integer> timeList,
                                                    List<Double> depthList) {
        DiveStatistic diveStatistic = new DiveStatistic();

        diveStatistic.setTotalTimeUnderwaterInMinutes(getTotalTimeFromTimeList(timeList));
        diveStatistic.setTotalAmountOfDives(totalNumberOfDives);
        diveStatistic.setAverageDiveDepthInMeters(roundToTwoDP(getAverageDepthFromDepthList(depthList)));
        diveStatistic.setDeepestDiveDepthInMeters(roundToTwoDP(getDeepestDepthFromDepthList(depthList)));
        diveStatistic.setShallowestDiveDepthInMeters(roundToTwoDP(getShallowestDepthFromDepthList(depthList)));

        return diveStatistic;
    }
}
