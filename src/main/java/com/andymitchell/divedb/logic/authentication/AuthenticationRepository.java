package com.andymitchell.divedb.logic.authentication;

public interface AuthenticationRepository {

    Token createToken(String tokenName);

    boolean validateToken(String token);
}
