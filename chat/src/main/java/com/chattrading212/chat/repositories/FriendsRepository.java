package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.FriendsEntity;

import java.util.UUID;

public interface FriendsRepository {
    void createFriendship(UUID userUuid, UUID friendUuid, String friendNickname, Integer friendPictureId);
    void deleteFriendship(UUID userUuid, UUID friendUuid);

    FriendsEntity getFriendship(UUID userUuid, UUID friendUuid);
}
