package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.UserEntity;
import com.chattrading212.chat.services.models.UserModel;

public class UserMapper {
    public static UserModel toUserEntity(UserEntity userEntity) {
        return new UserModel(userEntity.userUuid, userEntity.email, userEntity.password, userEntity.nickname, userEntity.createdAt, userEntity.isDeleted);
    }

    public static UserEntity toUserModel(UserModel userModel) {
        return new UserEntity(userModel.userUuid, userModel.email, userModel.password, userModel.nickname, userModel.createdAt, userModel.isDeleted);
    }
}
