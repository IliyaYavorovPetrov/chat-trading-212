package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.FriendsEntity;
import com.chattrading212.chat.services.models.FriendsModel;

public class FriendsMapper {
    public static FriendsModel toFriendModel(FriendsEntity friendsEntity) {
        return new FriendsModel(friendsEntity.userUuid, friendsEntity.createdAt, friendsEntity.isDeleted, friendsEntity.friendUuid, friendsEntity.friendNickname, friendsEntity.friendPictureId);
    }

    public static FriendsEntity toFriendEntity(FriendsModel friendsModel) {
        return new FriendsEntity(friendsModel.userUuid, friendsModel.createdAt, friendsModel.isDeleted, friendsModel.friendUuid, friendsModel.friendNickname, friendsModel.friendPictureId);
    }
}
