package com.williams.spring_auth_initializer.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RegisterException extends ResponseStatusException {
    public RegisterException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
