package com.chattrading212.chat.services.models;

import java.util.UUID;

public class GroupModel {
    public final UUID groupUuid;
    public final String groupName;
    public final String groupUrl;

    public GroupModel(UUID groupUuid, String groupName, String groupUrl) {
        this.groupUuid = groupUuid;
        this.groupName = groupName;
        this.groupUrl = groupUrl;
    }

    @Override
    public String toString() {
        return "GroupModel{" +
                "groupUuid=" + groupUuid +
                ", groupName='" + groupName + '\'' +
                ", groupUrl='" + groupUrl + '\'' +
                '}';
    }
}
