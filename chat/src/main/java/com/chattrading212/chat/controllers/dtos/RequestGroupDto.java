package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class RequestGroupDto {
    public final String groupName;
    public final String groupUrl;
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;

    public RequestGroupDto(String groupName, String groupUrl, UUID userUuid, String userNickname, Integer userPictureId) {
        this.groupName = groupName;
        this.groupUrl = groupUrl;
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
    }
}
