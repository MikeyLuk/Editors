package com.andymitchell.divedb.presentation;

import com.andymitchell.divedb.presentation.api.TokenInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(TokenInvalidException.class);

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Token Invalid Exception occurred")
    @ExceptionHandler(TokenInvalidException.class)
    public void handleIOException() {
        logger.error("Token Invalid Exception handler executed");
        //returning 404 error code
    }
}