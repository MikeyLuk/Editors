package com.andymitchell.divedb.data.dives;

import com.andymitchell.divedb.logic.DiveStatistic;
import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DiveRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDiveRepository implements DiveRepository {
    private List<Dive> diveList;
    private int id = 0;

    public InMemoryDiveRepository() {
        this.diveList = new ArrayList<>();
    }

    @Override
    public Dive save(Dive dive) {
        dive.setId(id++);
        if (!diveList.contains(dive)) {
            diveList.add(dive);
            return diveList.get(diveList.indexOf(dive));
        }
        return null;
    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }

    @Override
    public List<Dive> getDivesFromDate(LocalDate date) {
        List<Dive> returnDiveList = new ArrayList<>();
        for (Dive dive : diveList) {
            if (dive.getDate().equals(date)) {
                returnDiveList.add(dive);
            }
        }
        return returnDiveList;
    }

    @Override
    public List<Dive> getDivesFromLocation(String location) {
        List<Dive> returnDiveList = new ArrayList<>();
        for (Dive dive : diveList) {
            if (dive.getLocation().toLowerCase().equals(location.toLowerCase())) {
                returnDiveList.add(dive);
            }
        }
        return returnDiveList;
    }

    @Override
    public List<Dive> getDivesFromDateAndLocation(LocalDate date, String location) {
        List<Dive> returnDiveList = new ArrayList<>();
        for (Dive dive : diveList) {
            if (dive.getDate().equals(date) && dive.getLocation().toLowerCase().equals(location.toLowerCase())) {
                returnDiveList.add(dive);
            }
        }
        return returnDiveList;
    }

    @Override
    public Dive getDiveFromId(int id) {
        for (Dive dive : diveList) {
            if (dive.getId() == id) {
                return dive;
            }
        }
        return null;
    }

    @Override
    public List<Dive> deleteAllDives() {
        List<Dive> returnList = new ArrayList<>();
        returnList.addAll(diveList);
        diveList.clear();

        return returnList;
    }

    @Override
    public Dive deleteDiveFromId(int id) {
        Dive diveToDelete = null;
        for (Dive dive : diveList) {
            if (dive.getId() == id) {
                diveToDelete = dive;
            }
        }
        if (diveToDelete != null) {
            diveList.remove(diveToDelete);
            return diveToDelete;
        }
        return null;
    }

    @Override
    public List<Dive> updateMultipleDives(List<Dive> updatedDiveList) {
        List<Dive> returnDiveList = new ArrayList<>();

        for (Dive updatedDive : updatedDiveList) {
            for (Dive existingDive:diveList) {
                if(updatedDive.getId() == existingDive.getId()) {
                    diveList.set(diveList.indexOf(existingDive),updatedDive);
                    returnDiveList.add(diveList.get(diveList.indexOf(updatedDive)));
                }
            }
        }
        return returnDiveList;
    }

    @Override
    public Dive updateDiveFromId(int id, Dive dive) {
        dive.setId(id);
        Integer diveIndex = -1;
        for (Dive d : diveList) {
            if (d.getId() == id) {
                diveIndex = diveList.indexOf(d);
            }
        }
        if (diveIndex != -1) {
            diveList.set(diveIndex,dive);
            return diveList.get(diveList.indexOf(dive));
        }
        return null;
    }

    @Override
    public DiveStatistic getDiveStatistic() {
        return null;
    }

}
