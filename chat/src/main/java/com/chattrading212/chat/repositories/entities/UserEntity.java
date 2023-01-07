package com.chattrading212.chat.repositories.entities;

import java.time.Instant;
import java.util.UUID;

public class UserEntity {
    public final UUID userUuid;
    public final String email;
    public final String password;
    public final String nickname;
    public final Instant createdAt;
    public final Boolean isDeleted;
    public final Integer pictureId;

    public UserEntity(UUID userUuid, String email, String password, String nickname, Instant createdAt, Boolean isDeleted, Integer pictureId) {
        this.userUuid = userUuid;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.pictureId = pictureId;
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
