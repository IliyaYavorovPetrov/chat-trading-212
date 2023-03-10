package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class UserDto {
    public final UUID userUuid;
    public final String nickname;
    public final String email;
    public final Integer pictureId;
    public UserDto(UUID userUUID, String nickname, String email, Integer pictureId) {
        this.userUuid = userUUID;
        this.nickname = nickname;
        this.email = email;
        this.pictureId = pictureId;
    }
}
