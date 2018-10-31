package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.authentication.Token;
import com.andymitchell.divedb.logic.user.User;
import com.andymitchell.divedb.logic.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class AuthenticationAPIController {

    @Resource
    private AuthenticationService authenticationService;

    @Resource
    private UserService userService;

    @PostMapping("/authenticate")
    public Token createToken(@RequestBody User user) {
        User userFromDb = userService.validateUser(user);
        if (userFromDb != null) {
            return authenticationService.createToken(userFromDb.getId());
        }
        return null;
    }
}
