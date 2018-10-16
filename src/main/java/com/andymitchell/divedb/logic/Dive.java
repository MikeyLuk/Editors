package com.andymitchell.divedb.logic;

import java.time.LocalDate;

public class Dive {
    private LocalDate date;
    private String location;
    private int durationInMinutes;
    private int maxDepthInMeters;
    private String waterConditions;
    private boolean performedSafetyStop;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getMaxDepthInMeters() {
        return maxDepthInMeters;
    }

    public void setMaxDepthInMeters(int maxDepthInMeters) {
        this.maxDepthInMeters = maxDepthInMeters;
    }

    public String getWaterConditions() {
        return waterConditions;
    }

    public void setWaterConditions(String waterConditions) {
        this.waterConditions = waterConditions;
    }

    public boolean isPerformedSafetyStop() {
        return performedSafetyStop;
    }

    public void setPerformedSafetyStop(boolean performedSafetyStop) {
        this.performedSafetyStop = performedSafetyStop;
    }
}
