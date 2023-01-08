package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.FriendshipModel;

public class FriendshipMapper {
    public static FriendshipModel toFriendshipModel(FriendshipEntity friendshipEntity) {
        return new FriendshipModel(friendshipEntity.friendshipUuid, friendshipEntity.createdAt, friendshipEntity.isDeleted, friendshipEntity.userUuid, friendshipEntity.userNickname, friendshipEntity.userPictureId, friendshipEntity.friendUuid, friendshipEntity.friendNickname, friendshipEntity.friendPictureId);
    }

    public static FriendshipEntity toFriendshipEntity(FriendshipModel friendshipModel) {
        return new FriendshipEntity(friendshipModel.friendshipUuid, friendshipModel.createdAt, friendshipModel.isDeleted, friendshipModel.userUuid, friendshipModel.userNickname, friendshipModel.userPictureId, friendshipModel.friendUuid, friendshipModel.friendNickname, friendshipModel.friendPictureId);
    }
}
