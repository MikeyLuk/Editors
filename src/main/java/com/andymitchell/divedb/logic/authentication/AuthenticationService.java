package com.andymitchell.divedb.logic.authentication;

import com.andymitchell.divedb.presentation.api.TokenInvalidException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Token createToken(int userId) {
        Key tokenKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String tokenValue = Jwts.builder().setSubject(Integer.toString(userId)).signWith(tokenKey).compact();

        if (tokenIsFromUser(userId, tokenKey, tokenValue)) {
            return authenticationRepository.createToken(tokenValue);
        } else {
            return null;
        }
    }

    public void validateToken (String token) {
        if (!authenticationRepository.validateToken(token)) {
            throw new TokenInvalidException();
        }
    }

    private boolean tokenIsFromUser(int userId, Key tokenKey, String tokenValue) {
        return Jwts.parser().setSigningKey(tokenKey).parseClaimsJws(tokenValue)
                .getBody().getSubject().equals(Integer.toString(userId));
    }

}
