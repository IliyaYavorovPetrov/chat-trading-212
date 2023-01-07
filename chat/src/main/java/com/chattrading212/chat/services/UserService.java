package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.chattrading212.chat.services.models.UserModel;

import java.text.ParseException;
import java.util.Random;
import java.util.UUID;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel getByUUID(UUID userUuid) {
        return UserMapper.toUserEntity(repository.getByUUID(userUuid));
    }
    public Boolean doesUUIDExists(UUID userUuid) {
        return repository.doesUUIDExists(userUuid);
    }
    public UserModel getByEmail(String email) {
        return UserMapper.toUserEntity(repository.getByEmail(email));
    }
    public Boolean doesEmailExists(String email) {
        return repository.doesEmailExists(email);
    }
}
