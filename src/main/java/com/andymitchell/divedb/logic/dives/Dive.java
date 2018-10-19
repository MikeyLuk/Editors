package com.andymitchell.divedb.logic.dives;

import java.time.LocalDate;
import java.util.Objects;

public class Dive {
    private int id;
    private LocalDate date;
    private String location;
    private int durationInMinutes;
    private double maxDepthInMeters;
    private String waterConditions;
    private boolean performedSafetyStop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getMaxDepthInMeters() {
        return maxDepthInMeters;
    }

    public void setMaxDepthInMeters(double maxDepthInMeters) {
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
