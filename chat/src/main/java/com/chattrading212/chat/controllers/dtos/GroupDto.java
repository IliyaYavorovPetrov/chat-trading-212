package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class GroupDto {
    public final UUID groupUuid;
    public final String groupName;
    public final String groupUrl;

    public GroupDto(UUID groupUuid, String groupName, String groupUrl) {
        this.groupUuid = groupUuid;
        this.groupName = groupName;
        this.groupUrl = groupUrl;
    }
}
