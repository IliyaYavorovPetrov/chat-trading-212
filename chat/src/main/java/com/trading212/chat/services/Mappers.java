package com.trading212.chat.services;

import com.trading212.chat.repository.entities.UserEntity;
import com.trading212.chat.services.models.UserModel;

class Mappers {
    public static UserModel fromUserEntity(UserEntity user) {
        return new UserModel(user.id, user.firstName, user.lastName);
    }
}
