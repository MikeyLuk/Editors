package com.andymitchell.divedb.logic.authentication;

import com.andymitchell.divedb.logic.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Token createToken(int userId) {
        return authenticationRepository.createToken(userId);
    }

}
