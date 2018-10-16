package com.andymitchell.divedb.data;

import com.andymitchell.divedb.logic.Dive;
import com.andymitchell.divedb.logic.DiveRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDiveRepository implements DiveRepository {
    private List<Dive> diveList;

    public InMemoryDiveRepository() {
        this.diveList = new ArrayList<>();
    }

    @Override
    public Dive save(Dive dive) {
        diveList.add(dive);
        return dive;
    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }
}
