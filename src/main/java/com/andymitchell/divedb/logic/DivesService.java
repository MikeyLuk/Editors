package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.data.InMemoryDiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivesService {

    private DiveRepository diveRepository = new InMemoryDiveRepository();

    public List<Dive> getAllDives() {
        return diveRepository.getAllDives();
    }

    public Dive save(Dive dive) {
        return diveRepository.save(dive);
    }
}
