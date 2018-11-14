package com.andymitchell.divedb.logic.dives;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import com.andymitchell.divedb.logic.user.UserService;
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

    public List<Dive> getAllDives(int userId) {
        return diveRepository.getAllDives(userId);
    }

    public List<Dive> getDivesFromDate(LocalDate date, int userId) {
        return diveRepository.getDivesFromDate(date, userId);
    }

    public List<Dive> getDivesFromLocation(String location, int userId) {
        return diveRepository.getDivesFromLocation(location, userId);
    }

    public List<Dive> getDivesFromDateAndLocation(LocalDate date, String location, int userId) {
        return diveRepository.getDivesFromDateAndLocation(date, location, userId);
    }

    public Dive save(Dive dive, int userId) {
        return diveRepository.save(dive, userId);
    }

    public List<Dive> deleteAllDives(int userId) {
        return diveRepository.deleteAllDives(userId);
    }

    public Dive deleteDiveFromId(int id, int userId) {
        return diveRepository.deleteDiveFromId(id, userId);
    }

    public Dive getDiveFromId(int id, int userId) {
        return diveRepository.getDiveFromId(id, userId);
    }

    public List<Dive> updateMultipleDives(List<Dive> updatedDives,int userId) {
        return diveRepository.updateMultipleDives(updatedDives, userId);
    }

    public Dive updateDiveFromId(int id, Dive dive, int userId) {
        return diveRepository.updateDiveFromId(id, dive, userId);
    }

    public DiveStatistic getDiveStatistic(int userId) {
        return diveRepository.getDiveStatistic(userId);
    }
}
