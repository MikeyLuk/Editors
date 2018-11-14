package com.andymitchell.divedb.logic.dives;

import com.andymitchell.divedb.logic.statistics.DiveStatistic;

import java.time.LocalDate;
import java.util.List;

public interface DiveRepository {
    Dive save(Dive dive, int userId);
    List<Dive> getAllDives(int userId);
    List<Dive> getDivesFromDate(LocalDate date, int userId);
    List<Dive> getDivesFromLocation(String location, int userId);
    List<Dive> getDivesFromDateAndLocation(LocalDate date, String location, int userId);
    Dive getDiveFromId(int id, int userId);
    List<Dive> deleteAllDives(int userId);
    Dive deleteDiveFromId(int id, int userId);
    List<Dive> updateMultipleDives(List<Dive> updatedDiveList, int userId);
    Dive updateDiveFromId(int id, Dive dive, int userId);
    DiveStatistic getDiveStatistic(int userId);
}
