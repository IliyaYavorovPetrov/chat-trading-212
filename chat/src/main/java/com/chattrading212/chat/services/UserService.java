package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.services.models.UserModel;

import java.util.UUID;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel getByUUID(UUID userUuid) {
        return UserMapper.toUserModel(repository.getByUUID(userUuid));
    }
    public Boolean doesUUIDExists(UUID userUuid) {
        return repository.doesUUIDExists(userUuid);
    }
    public UserModel getByEmail(String email) {
        return UserMapper.toUserModel(repository.getByEmail(email));
    }
    public Boolean doesEmailExists(String email) {
        return repository.doesEmailExists(email);
    }
}
