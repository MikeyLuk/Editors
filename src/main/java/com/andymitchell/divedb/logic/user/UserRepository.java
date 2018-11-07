package com.andymitchell.divedb.logic.user;

public interface UserRepository {

    User findByEmail(String email);

    User save(User user);

    void deleteUserById(int id);
}
