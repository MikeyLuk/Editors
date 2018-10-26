package com.andymitchell.divedb.logic;

public interface UserRoleRepository {
    void addUserRoleLink(int userId, int roleId);
}
