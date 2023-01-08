package com.chattrading212.chat.mappers;

import com.chattrading212.chat.controllers.dtos.UserDto;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.chattrading212.chat.services.models.UserModel;

public class UserMapper {
    public static UserModel toUserModel(UserEntity userEntity) {
        return new UserModel(userEntity.userUuid, userEntity.email, userEntity.password, userEntity.nickname, userEntity.createdAt, userEntity.isDeleted, userEntity.pictureId);
    }

    public static UserEntity toUserEntity(UserModel userModel) {
        return new UserEntity(userModel.userUuid, userModel.email, userModel.password, userModel.nickname, userModel.createdAt, userModel.isDeleted, userModel.pictureId);
    }

    public static UserDto toUserDto(String jwtToken, UserModel userModel) {
        return new UserDto(jwtToken, userModel.userUuid, userModel.nickname, userModel.email, userModel.pictureId, userModel.isDeleted);
    }
}
