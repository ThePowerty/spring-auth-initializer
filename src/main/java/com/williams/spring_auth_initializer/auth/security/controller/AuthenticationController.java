package com.williams.spring_auth_initializer.auth.security.controller;

import com.williams.spring_auth_initializer.auth.security.dto.JwtResponse;
import com.williams.spring_auth_initializer.auth.security.dto.LoginRequest;
import com.williams.spring_auth_initializer.auth.security.dto.MessageResponse;
import com.williams.spring_auth_initializer.auth.security.dto.RegisterRequest;
import com.williams.spring_auth_initializer.auth.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @RequestBody LoginRequest authRequest){

        JwtResponse jwtDTO = authenticationService.login(authRequest);

        return ResponseEntity.ok(jwtDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(
            @RequestBody RegisterRequest authRequest) {

        MessageResponse messageResponse = authenticationService.register(authRequest).getBody();

        return ResponseEntity.ok(messageResponse);
    }
}
