package com.chattrading212.chat.controllers.dtos;

import java.time.Instant;
import java.util.UUID;

public class DirectMsgDto {
    public final UUID chatUuid;
    public final Instant createdAt;
    public Boolean isDeleted;
    public final String msgText;
    public final UUID fromUserUuid;
    public final String fromUserNickname;
    public final Integer fromUserPictureId;

    public DirectMsgDto(UUID chatUuid, Instant createdAt, Boolean isDeleted, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId) {
        this.chatUuid = chatUuid;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.msgText = msgText;
        this.fromUserUuid = fromUserUuid;
        this.fromUserNickname = fromUserNickname;
        this.fromUserPictureId = fromUserPictureId;
    }
}
