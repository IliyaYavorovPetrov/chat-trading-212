package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.FriendshipEntity;

import java.util.UUID;

public interface FriendshipRepository {
    void createFriendship(UUID userUuid, UUID friendUuid, String friendNickname, Integer friendPictureId);
    void deleteFriendship(UUID userUuid, UUID friendUuid);
    FriendshipEntity getFriendship(UUID userUuid, UUID friendUuid);
}
