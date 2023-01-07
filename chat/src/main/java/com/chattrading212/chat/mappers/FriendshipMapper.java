package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.FriendshipModel;

public class FriendshipMapper {
    public static FriendshipModel toFriendModel(FriendshipEntity friendshipEntity) {
        return new FriendshipModel(friendshipEntity.userUuid, friendshipEntity.createdAt, friendshipEntity.isDeleted, friendshipEntity.friendUuid, friendshipEntity.friendNickname, friendshipEntity.friendPictureId);
    }

    public static FriendshipEntity toFriendEntity(FriendshipModel friendshipModel) {
        return new FriendshipEntity(friendshipModel.userUuid, friendshipModel.createdAt, friendshipModel.isDeleted, friendshipModel.friendUuid, friendshipModel.friendNickname, friendshipModel.friendPictureId);
    }
}
