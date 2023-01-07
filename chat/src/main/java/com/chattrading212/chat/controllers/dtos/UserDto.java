package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class UserDto {
    public final String token;
    public final UUID userUuid;
    public final String nickname;
    public final String email;
    public final Integer pictureId;
    public Boolean isDeleted;

    public UserDto(String token, UUID userUUID, String nickname, String email, Integer pictureId, Boolean isDeleted) {
        this.token = token;
        this.userUuid = userUUID;
        this.nickname = nickname;
        this.email = email;
        this.pictureId = pictureId;
        this.isDeleted = isDeleted;
    }
}
