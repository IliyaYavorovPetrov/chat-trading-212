package com.chattrading212.chat.services.models;

import java.time.Instant;
import java.util.UUID;

public class FriendshipModel {
    public final UUID friendshipUuid;
    public final Instant createdAt;
    public final Boolean isDeleted;
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;
    public final UUID friendUuid;
    public final String friendNickname;
    public final Integer friendPictureId;

    public FriendshipModel(UUID friendshipUuid, Instant createdAt, Boolean isDeleted, UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        this.friendshipUuid = friendshipUuid;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
        this.friendUuid = friendUuid;
        this.friendNickname = friendNickname;
        this.friendPictureId = friendPictureId;
    }

    @Override
    public String toString() {
        return "FriendshipModel{" +
                "friendshipUuid=" + friendshipUuid +
                ", createdAt=" + createdAt +
                ", isDeleted=" + isDeleted +
                ", userUuid=" + userUuid +
                ", userNickname='" + userNickname + '\'' +
                ", userPictureId=" + userPictureId +
                ", friendUuid=" + friendUuid +
                ", friendNickname='" + friendNickname + '\'' +
                ", friendPictureId=" + friendPictureId +
                '}';
    }
}
