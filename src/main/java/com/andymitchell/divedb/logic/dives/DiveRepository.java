package com.andymitchell.divedb.logic.dives;

import com.andymitchell.divedb.logic.statistics.DiveStatistic;

import java.time.LocalDate;
import java.util.List;

public interface DiveRepository {
    Dive save(Dive dive);
    List<Dive> getAllDives();
    List<Dive> getDivesFromDate(LocalDate date);
    List<Dive> getDivesFromLocation(String location);
    List<Dive> getDivesFromDateAndLocation(LocalDate date, String location);
    Dive getDiveFromId(int id);
    List<Dive> deleteAllDives();
    Dive deleteDiveFromId(int id);
    List<Dive> updateMultipleDives(List<Dive> updatedDiveList);
    Dive updateDiveFromId(int id, Dive dive);
    DiveStatistic getDiveStatistic();
}
