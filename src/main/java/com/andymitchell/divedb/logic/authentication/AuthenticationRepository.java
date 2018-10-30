package com.andymitchell.divedb.logic.authentication;

import com.andymitchell.divedb.logic.user.User;

public interface AuthenticationRepository {

    Token createToken(int userId);
}
