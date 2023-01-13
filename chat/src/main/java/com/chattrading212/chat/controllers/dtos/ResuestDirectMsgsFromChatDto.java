package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class ResuestDirectMsgsFromChatDto {
    public final UUID chatUuid;

    public ResuestDirectMsgsFromChatDto(UUID chatUuid) {
        this.chatUuid = chatUuid;
    }
}
