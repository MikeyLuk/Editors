package com.andymitchell.divedb.logic.authentication;

import com.andymitchell.divedb.presentation.api.TokenInvalidException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class AuthenticationService {

    private Key tokenKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Token createToken(int userId) {

        String tokenValue = Jwts.builder().setSubject(Integer.toString(userId)).signWith(tokenKey).compact();

        if (tokenIsFromUser(userId, tokenValue)) {
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

    private boolean tokenIsFromUser(int userId, String tokenValue) {
        return Jwts.parser()
                .setSigningKey(tokenKey)
                .parseClaimsJws(tokenValue)
                .getBody()
                .getSubject()
                .equals(Integer.toString(userId));
    }

    public int getUserIdFromToken(String tokenValue) {
        String user = Jwts.parser()
                .setSigningKey(tokenKey)
                .parseClaimsJws(tokenValue)
                .getBody()
                .getSubject().;

        return Integer.parseInt(user);
    }

}
