package com.andymitchell.divedb.logic;

import java.util.List;

public class StatisticUtils {
    public static int getTotalTimeFromTimeList (List<Integer> timeList) {

        return timeList.stream().mapToInt(Integer::intValue).sum();
    }

    public static Double getAverageDepthFromDepthList (List<Double> depthList) {

        double totalMetersDived = depthList.stream().mapToDouble(Double::doubleValue).sum();

        return totalMetersDived/(double)depthList.size();
    }

    public static Double getShallowestDepthFromDepthList (List<Double> depthList) {

        Double currentShallowestDepth = null;
        for (Double depth : depthList) {
            if (currentShallowestDepth == null || depth < currentShallowestDepth) {
                currentShallowestDepth = depth;
            }
        }

        return currentShallowestDepth;
    }

    public static Double getDeepestDepthFromDepthList (List<Double> depthList) {

        Double currentDeepestDepth = null;
        for (Double depth : depthList) {
            if (currentDeepestDepth == null || depth > currentDeepestDepth) {
                currentDeepestDepth = depth;
            }
        }
        return currentDeepestDepth;
    }

    public static Double roundToTwoDP(Double input) {
        if (input == null) return null;
        return (double) Math.round(input * 100d) / 100d;
    }
}
