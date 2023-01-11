package com.chattrading212.chat.mappers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.repositories.entities.DirectMsgEntity;
import com.chattrading212.chat.services.models.DirectMsgModel;

public class DirectMsgMapper {
    public static DirectMsgModel toDirectMsgModel (DirectMsgEntity directMsgEntity) {
        return new DirectMsgModel(directMsgEntity.msgUuid, directMsgEntity.chatUuid, directMsgEntity.createdAt, directMsgEntity.isDeleted, directMsgEntity.msgText, directMsgEntity.fromUserUuid, directMsgEntity.fromUserNickname, directMsgEntity.fromUserPictureId);
    }

    public static DirectMsgEntity toDirectMsgEntity (DirectMsgModel directMsgModel) {
        return new DirectMsgEntity(directMsgModel.msgUuid, directMsgModel.chatUuid, directMsgModel.createdAt, directMsgModel.isDeleted, directMsgModel.msgText, directMsgModel.fromUserUuid, directMsgModel.fromUserNickname, directMsgModel.fromUserPictureId);
    }

    public static DirectMsgDto toDirectMsgDto (DirectMsgModel directMsgModel) {
        return new DirectMsgDto(directMsgModel.chatUuid, directMsgModel.createdAt, directMsgModel.isDeleted, directMsgModel.msgText, directMsgModel.fromUserUuid, directMsgModel.fromUserNickname, directMsgModel.fromUserPictureId);
    }
}
