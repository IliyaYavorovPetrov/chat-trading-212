package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.DirectMsgEntity;

import java.util.UUID;

public interface DirectMsgRepository {
    DirectMsgEntity createDirectMsg(UUID msgUuid, UUID chatUuid, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId);

    DirectMsgEntity getDirectMsg(UUID msgUuid);
}
