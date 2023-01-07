package com.chattrading212.chat.controllers.dtos;

public class UserDto {
    public final String token;
    public final String nickname;
    public final String email;

    public UserDto(String token, String nickname, String email) {
        this.token = token;
        this.nickname = nickname;
        this.email = email;
    }
}
