package com.trading212.chat.repositories.entities;

import java.time.LocalDate;

public class UserEntity {
    public final String userUUID;
    public final String nickname;
    public final LocalDate createdAt;
    public final String password;
    public final String username;

    public UserEntity(String userUUID, String nickname, LocalDate createdAt, String password, String username) {
        this.userUUID = userUUID;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.password = password;
        this.username = username;
    }
}
