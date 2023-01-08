package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.DirectMsgMapper;
import com.chattrading212.chat.repositories.DirectMsgRepository;
import com.chattrading212.chat.repositories.entities.DirectMsgEntity;
import com.chattrading212.chat.services.models.DirectMsgModel;
import com.datastax.oss.driver.api.core.uuid.Uuids;

import java.util.UUID;

public class DirectMsgService {
    private final DirectMsgRepository directMsgRepository;

    public DirectMsgService(DirectMsgRepository directMsgRepository) {
        this.directMsgRepository = directMsgRepository;
    }

    public DirectMsgModel createDirectMsg(UUID chatUuid, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId) {
        UUID msgUuid = Uuids.timeBased();
        return DirectMsgMapper.toDirectMsgModel(directMsgRepository.createDirectMsg(msgUuid, chatUuid, msgText, fromUserUuid, fromUserNickname, fromUserPictureId));
    }

    public DirectMsgModel getDirectMsg(UUID msgUuid) {
        return DirectMsgMapper.toDirectMsgModel(directMsgRepository.getDirectMsg(msgUuid));
    }
}
