package com.chattrading212.chat.controllers.dtos;

public class LoginDto {
    public final String email;
    public final String password;

    public LoginDto(String email, String password_hash) {
        this.email = email;
        this.password = password_hash;
    }
}
