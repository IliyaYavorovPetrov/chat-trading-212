package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class UserUuidRequestDto {
    public final UUID userUuid;

    public UserUuidRequestDto(UUID userUuid) {
        this.userUuid = userUuid;
    }
}
