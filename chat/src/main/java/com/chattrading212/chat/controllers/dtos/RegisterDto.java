package com.chattrading212.chat.controllers.dtos;

public class RegisterDto {
    public final String email;
    public final String password;
    public final String nickname;

    public RegisterDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
