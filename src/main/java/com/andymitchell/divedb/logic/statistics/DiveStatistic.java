package com.andymitchell.divedb.logic.statistics;

public class DiveStatistic {
    private Integer totalAmountOfDives;
    private Integer totalTimeUnderwaterInMinutes;
    private Double averageDiveDepthInMeters;
    private Double deepestDiveDepthInMeters;
    private Double shallowestDiveDepthInMeters;

    public Integer getTotalAmountOfDives() {
        return totalAmountOfDives;
    }

    public void setTotalAmountOfDives(Integer totalAmountOfDives) {
        this.totalAmountOfDives = totalAmountOfDives;
    }

    public Integer getTotalTimeUnderwaterInMinutes() {
        return totalTimeUnderwaterInMinutes;
    }

    public void setTotalTimeUnderwaterInMinutes(Integer totalTimeUnderwaterInMinutes) {
        this.totalTimeUnderwaterInMinutes = totalTimeUnderwaterInMinutes;
    }

    public Double getAverageDiveDepthInMeters() {
        return averageDiveDepthInMeters;
    }

    public void setAverageDiveDepthInMeters(Double averageDiveDepthInMeters) {
        this.averageDiveDepthInMeters = averageDiveDepthInMeters;
    }

    public Double getDeepestDiveDepthInMeters() {
        return deepestDiveDepthInMeters;
    }

    public void setDeepestDiveDepthInMeters(Double deepestDiveDepthInMeters) {
        this.deepestDiveDepthInMeters = deepestDiveDepthInMeters;
    }

    public Double getShallowestDiveDepthInMeters() {
        return shallowestDiveDepthInMeters;
    }

    public void setShallowestDiveDepthInMeters(Double shallowestDiveDepthInMeters) {
        this.shallowestDiveDepthInMeters = shallowestDiveDepthInMeters;
    }
}
