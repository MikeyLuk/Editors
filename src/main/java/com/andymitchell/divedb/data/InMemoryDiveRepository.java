package com.andymitchell.divedb.data;

import com.andymitchell.divedb.logic.Dive;
import com.andymitchell.divedb.logic.DiveRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDiveRepository implements DiveRepository {
    private List<Dive> diveList;

    public InMemoryDiveRepository() {
        this.diveList = new ArrayList<>();
    }

    @Override
    public Dive save(Dive dive) {
        if (!diveList.contains(dive)) {
            diveList.add(dive);
            return dive;
        }
        return null;
    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }

    @Override
    public Dive getDiveFromDateAndLocation(LocalDate date, String location) {
        for (Dive dive : diveList) {
            if (dive.getDate().equals(date) && dive.getLocation().toLowerCase().equals(location.toLowerCase())) {
                return dive;
            }
        }
        return null;
    }

    @Override
    public Dive deleteDiveFromDateAndLocation(LocalDate date, String location) {
        Dive diveToRemove = getDiveFromDateAndLocation(date,location);

        if (diveToRemove != null) {
            diveList.remove(diveToRemove);
            return diveToRemove;
        }
        return null;
    }
}
