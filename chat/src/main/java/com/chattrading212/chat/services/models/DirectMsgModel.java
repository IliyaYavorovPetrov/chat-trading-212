package com.chattrading212.chat.services.models;

import java.time.Instant;
import java.util.UUID;

public class DirectMsgModel {
    public final UUID msgUuid;
    public final UUID chatUuid;
    public final Instant createdAt;
    public Boolean isDeleted;
    public final String msgText;
    public final UUID fromUserUuid;
    public final String fromUserNickname;
    public final Integer fromUserPictureId;

    public DirectMsgModel(UUID msgUuid, UUID chatUuid, Instant createdAt, Boolean isDeleted, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId) {
        this.msgUuid = msgUuid;
        this.chatUuid = chatUuid;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.msgText = msgText;
        this.fromUserUuid = fromUserUuid;
        this.fromUserNickname = fromUserNickname;
        this.fromUserPictureId = fromUserPictureId;
    }

    @Override
    public String toString() {
        return "DirectMsgModel{" +
                "msgUuid=" + msgUuid +
                ", chatUuid=" + chatUuid +
                ", createdAt=" + createdAt +
                ", isDeleted=" + isDeleted +
                ", fromUserUuid=" + fromUserUuid +
                ", fromUserNickname='" + fromUserNickname + '\'' +
                ", fromUserPictureId=" + fromUserPictureId +
                '}';
    }
}
