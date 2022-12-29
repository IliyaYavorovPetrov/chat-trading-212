package com.trading212.chat.services;

import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.services.models.UserModel;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel createUser(int id, String firstName, String lastName) {
        return Mappers.fromUserEntity(repository.crateUser(id, firstName, lastName));
    }
}
