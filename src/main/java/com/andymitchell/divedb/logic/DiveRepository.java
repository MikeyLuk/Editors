package com.andymitchell.divedb.logic;

import java.time.LocalDate;
import java.util.List;

public interface DiveRepository {
    Dive save(Dive dive);
    List<Dive> getAllDives();
    Dive getDiveFromDateAndLocation(LocalDate date, String location);
    Dive deleteDiveFromDateAndLocation(LocalDate date, String location);
    //Dive updateDiveFromDateAndLocation(LocalDate date, String location, Dive dive);
}
