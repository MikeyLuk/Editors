package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.data.InMemoryDiveRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DivesService {

    private DiveRepository diveRepository = new InMemoryDiveRepository();

    public List<Dive> getAllDives() {
        return diveRepository.getAllDives();
    }

    public Dive getDiveFromDateAndLocation(LocalDate date, String location) {
        return diveRepository.getDiveFromDateAndLocation(date,location);
    }

    public Dive save(Dive dive) {
        return diveRepository.save(dive);
    }

    public Dive deleteDiveFromDateAndLocation(LocalDate date, String location) {
        return diveRepository.deleteDiveFromDateAndLocation(date,location);
    }
}
