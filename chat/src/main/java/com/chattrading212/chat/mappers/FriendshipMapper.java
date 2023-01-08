package com.chattrading212.chat.mappers;

import com.chattrading212.chat.controllers.dtos.FriendDto;
import com.chattrading212.chat.controllers.dtos.FriendshipDto;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.FriendshipModel;

import java.util.UUID;

public class FriendshipMapper {
    public static FriendshipModel toFriendshipModel(FriendshipEntity friendshipEntity) {
        return new FriendshipModel(friendshipEntity.friendshipUuid, friendshipEntity.createdAt, friendshipEntity.isDeleted, friendshipEntity.userUuid, friendshipEntity.userNickname, friendshipEntity.userPictureId, friendshipEntity.friendUuid, friendshipEntity.friendNickname, friendshipEntity.friendPictureId);
    }

    public static FriendshipEntity toFriendshipEntity(FriendshipModel friendshipModel) {
        return new FriendshipEntity(friendshipModel.friendshipUuid, friendshipModel.createdAt, friendshipModel.isDeleted, friendshipModel.userUuid, friendshipModel.userNickname, friendshipModel.userPictureId, friendshipModel.friendUuid, friendshipModel.friendNickname, friendshipModel.friendPictureId);
    }

    // Extracts from FriendshipModel the friend of the user
    public static FriendDto toFriendDto(FriendshipModel friendshipDto, UUID userUuid) {
        if (friendshipDto.userUuid == userUuid) {
            return new FriendDto(friendshipDto.friendUuid, friendshipDto.friendNickname, friendshipDto.friendPictureId);
        }

        return new FriendDto(friendshipDto.userUuid, friendshipDto.userNickname, friendshipDto.userPictureId);
    }
}
