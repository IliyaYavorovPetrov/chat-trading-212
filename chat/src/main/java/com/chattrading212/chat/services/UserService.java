package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.chattrading212.chat.services.models.UserModel;

import java.util.UUID;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel createUser(String email, String password, String nickname) {
        return null;
    }
    public UserModel getByUUID(UUID userUuid) {
        return null;
    }
    public Boolean doesUUIDExists(UUID userUuid) {
        return null;
    }
    public UserModel getByEmail(String email) {
        return UserMapper.toUserEntity(repository.getByEmail(email));
    }
    Boolean doesEmailExists(String email) {
        return null;
    }
}
