package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.UserEntity;

import java.text.ParseException;
import java.util.UUID;

public interface UserRepository {
    void createUser(String email, String password, String nickname, Integer pictureId) throws ParseException;
    UserEntity getByUUID(UUID userUuid);
    Boolean doesUUIDExists(UUID userUuid);
    UserEntity getByEmail(String email);
    Boolean doesEmailExists(String email);

    void deleteUser(UUID userUuid);
}
