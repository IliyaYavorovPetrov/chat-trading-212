package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class RequestAddToGroupDto {
    public final UUID groupUuid;
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;

    public RequestAddToGroupDto(UUID groupUuid, UUID userUuid, String userNickname, Integer userPictureId) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
    }
}
