package com.chattrading212.chat.services.models;

import java.time.Instant;
import java.util.UUID;

public class UserModel {
    public final UUID userUuid;
    public final String email;
    public final String password;
    public final String nickname;
    public final Instant createdAt;
    public final Boolean isDeleted;

    public UserModel(UUID userUuid, String email, String password, String nickname, Instant createdAt, Boolean isDeleted) {
        this.userUuid = userUuid;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userUuid=" + userUuid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + nickname + '\'' +
                ", createdAt=" + createdAt +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
