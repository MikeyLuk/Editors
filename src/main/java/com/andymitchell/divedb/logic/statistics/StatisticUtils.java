package com.andymitchell.divedb.logic.statistics;

import com.andymitchell.divedb.logic.dives.Dive;

import java.util.List;

public class StatisticUtils {
    public static int getTotalTimeFromTimeDepthList(List<Dive> timeDepthList) {

        int totalTime = 0;

        for (Dive dive : timeDepthList) {
            totalTime += dive.getDurationInMinutes();
        }

        return totalTime;
    }

    public static Double getAverageDepthFromTimeDepthList(List<Dive> timeDepthList) {

        double totalMetersDived = 0;

        for (Dive dive : timeDepthList) {
            totalMetersDived += dive.getMaxDepthInMeters();
        }

        return totalMetersDived/(double)timeDepthList.size();
    }

    public static Double getShallowestDepthFromTimeDepthList(List<Dive> timeDepthList) {

        Double currentShallowestDepth = null;
        for (Dive dive : timeDepthList) {
            if (currentShallowestDepth == null || dive.getMaxDepthInMeters() < currentShallowestDepth) {
                currentShallowestDepth = dive.getMaxDepthInMeters();
            }
        }

        return currentShallowestDepth;
    }

    public static Double getDeepestDepthFromTimeDepthList(List<Dive> timeDepthList) {

        Double currentDeepestDepth = null;
        for (Dive dive : timeDepthList) {
            if (currentDeepestDepth == null || dive.getMaxDepthInMeters() > currentDeepestDepth) {
                currentDeepestDepth = dive.getMaxDepthInMeters();
            }
        }
        return currentDeepestDepth;
    }

    public static Double roundToTwoDP(Double input) {
        if (input == null) return null;
        return (double) Math.round(input * 100d) / 100d;
    }
}
