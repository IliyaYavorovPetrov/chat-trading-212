package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class RequestDirectMsgDto {
    public final UUID chatUuid;
    public final String msgText;
    public final UUID fromUserUuid;
    public final String fromUserNickname;
    public final Integer fromUserPictureId;

    public RequestDirectMsgDto(UUID chatUuid, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId) {
        this.chatUuid = chatUuid;
        this.msgText = msgText;
        this.fromUserUuid = fromUserUuid;
        this.fromUserNickname = fromUserNickname;
        this.fromUserPictureId = fromUserPictureId;
    }
}
