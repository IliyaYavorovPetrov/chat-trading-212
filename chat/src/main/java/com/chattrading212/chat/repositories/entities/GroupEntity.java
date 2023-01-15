package com.chattrading212.chat.repositories.entities;

import java.util.UUID;

public class GroupEntity {
    public final UUID groupUuid;
    public final String groupName;
    public final String groupUrl;

    public GroupEntity(UUID groupUuid, String groupName, String groupUrl) {
        this.groupUuid = groupUuid;
        this.groupName = groupName;
        this.groupUrl = groupUrl;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "groupUuid=" + groupUuid +
                ", groupName='" + groupName + '\'' +
                ", groupUrl='" + groupUrl + '\'' +
                '}';
    }
}
