package com.andymitchell.divedb.logic;

import java.util.List;

public interface DiveRepository {
    Dive save(Dive dive);
    List<Dive> getAllDives();
}
