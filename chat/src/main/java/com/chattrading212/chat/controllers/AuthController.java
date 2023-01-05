package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.AuthDto;
import com.chattrading212.chat.controllers.dtos.LoginDto;
import com.chattrading212.chat.controllers.dtos.RegisterDto;
import com.chattrading212.chat.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthDto> register(@RequestBody RegisterDto registerDto) throws ParseException {
        return ResponseEntity.ok(authService.register(registerDto));
    }
}
