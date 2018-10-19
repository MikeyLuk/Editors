package com.andymitchell.divedb.logic.dives;

import com.andymitchell.divedb.logic.DiveStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DivesService {

    private DiveRepository diveRepository;

    @Autowired
    public DivesService(DiveRepository diveRepository) {
        this.diveRepository = diveRepository;
    }

    public List<Dive> getAllDives() {
        return diveRepository.getAllDives();
    }

    public List<Dive> getDivesFromDate(LocalDate date) {
        return diveRepository.getDivesFromDate(date);
    }

    public List<Dive> getDivesFromLocation(String location) {
        return diveRepository.getDivesFromLocation(location);
    }

    public List<Dive> getDivesFromDateAndLocation(LocalDate date, String location) {
        return diveRepository.getDivesFromDateAndLocation(date, location);
    }

    public Dive save(Dive dive) {
        return diveRepository.save(dive);
    }

    public List<Dive> deleteAllDives() {
        return diveRepository.deleteAllDives();
    }

    public Dive deleteDiveFromId(int id) {
        return diveRepository.deleteDiveFromId(id);
    }

    public Dive getDiveFromId(int id) {
        return diveRepository.getDiveFromId(id);
    }

    public List<Dive> updateMultipleDives(List<Dive> updatedDives) {
        return diveRepository.updateMultipleDives(updatedDives);
    }

    public Dive updateDiveFromId(int id, Dive dive) {
        return diveRepository.updateDiveFromId(id, dive);
    }

    public DiveStatistic getDiveStatistic() {
        return diveRepository.getDiveStatistic();
    }
}
