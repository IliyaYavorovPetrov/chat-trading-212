package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.FriendshipEntity;

import java.util.List;
import java.util.UUID;

public interface FriendshipRepository {
    FriendshipEntity createFriendship(UUID friendshipUuid, UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId);
    FriendshipEntity deleteFriendship(UUID friendshipUuid);
    FriendshipEntity getFriendship(UUID friendshipUuid);
    List<FriendshipEntity> getUserFriendships(UUID userUuid);
}
