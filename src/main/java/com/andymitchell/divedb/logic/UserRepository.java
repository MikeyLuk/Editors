package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.logic.User;
import org.springframework.dao.EmptyResultDataAccessException;

public interface UserRepository {

    User findByEmail(String email);

    User save(User user);
}
