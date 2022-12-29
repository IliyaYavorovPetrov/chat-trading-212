package com.trading212.chat.repository;

import com.trading212.chat.repository.entities.UserEntity;

public interface UserRepository {
    UserEntity crateUser(int id, String firstName, String lastName);
}
