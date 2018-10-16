package com.andymitchell.divedb.logic;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dive dive = (Dive) o;
        return durationInMinutes == dive.durationInMinutes &&
                maxDepthInMeters == dive.maxDepthInMeters &&
                performedSafetyStop == dive.performedSafetyStop &&
                Objects.equals(date, dive.date) &&
                Objects.equals(location, dive.location) &&
                Objects.equals(waterConditions, dive.waterConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, location, durationInMinutes, maxDepthInMeters, waterConditions, performedSafetyStop);
    }
}
