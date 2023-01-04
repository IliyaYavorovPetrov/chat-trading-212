package com.chattrading212.chat.repositories.entities;

import java.util.Date;
import java.util.UUID;

public class UserEntity {
    UUID userUuid;
    String email;
    String password;
    String username;
    Date createdAt;
    Boolean isDeleted;
}
