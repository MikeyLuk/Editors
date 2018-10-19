package com.andymitchell.divedb.data;

import com.andymitchell.divedb.logic.statistics.DiveStatistic;

import java.util.List;

import com.andymitchell.divedb.logic.dives.Dive;

import static com.andymitchell.divedb.logic.statistics.StatisticUtils.*;

public class StatisticMapper {
    public static DiveStatistic mapToDiveStatistic (List<Dive> timeDepthList) {
        DiveStatistic diveStatistic = new DiveStatistic();

        diveStatistic.setTotalTimeUnderwaterInMinutes(getTotalTimeFromTimeDepthList(timeDepthList));
        diveStatistic.setTotalAmountOfDives(timeDepthList.size());
        diveStatistic.setAverageDiveDepthInMeters(roundToTwoDP(getAverageDepthFromTimeDepthList(timeDepthList)));
        diveStatistic.setDeepestDiveDepthInMeters(roundToTwoDP(getDeepestDepthFromTimeDepthList(timeDepthList)));
        diveStatistic.setShallowestDiveDepthInMeters(roundToTwoDP(getShallowestDepthFromTimeDepthList(timeDepthList)));

        return diveStatistic;
    }
}
