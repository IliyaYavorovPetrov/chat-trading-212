package com.chattrading212.chat.services.models;

import java.time.Instant;
import java.util.UUID;

public class FriendshipModel {
    public final UUID userUuid;
    public final Instant createdAt;
    public final Boolean isDeleted;
    public final UUID friendUuid;
    public final String friendNickname;
    public final Integer friendPictureId;

    public FriendshipModel(UUID userUuid, Instant createdAt, Boolean isDeleted, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        this.userUuid = userUuid;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.friendUuid = friendUuid;
        this.friendNickname = friendNickname;
        this.friendPictureId = friendPictureId;
    }

    @Override
    public String toString() {
        return "FriendsModel{" +
                "userUuid=" + userUuid +
                ", createdAt=" + createdAt +
                ", isDeleted=" + isDeleted +
                ", friendUuid=" + friendUuid +
                ", friendNickname='" + friendNickname + '\'' +
                ", friendPictureId=" + friendPictureId +
                '}';
    }
}
