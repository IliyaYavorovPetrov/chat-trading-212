package com.trading212.chat.repositories;

import com.trading212.chat.repositories.entities.UserEntity;

public interface UserRepository {
    UserEntity createUser(String username, String password, String nickname);
}
