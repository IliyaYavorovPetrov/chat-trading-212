package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.services.models.FriendshipModel;

import java.util.UUID;

public class FriendshipService {
    private final FriendshipRepository repository;

    public FriendshipService(FriendshipRepository repository) {
        this.repository = repository;
    }

    public FriendshipModel createFriendship(UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        repository.createFriendship(userUuid, friendUuid, friendNickname, friendPictureId);
        repository.createFriendship(friendUuid, userUuid, userNickname, userPictureId);
        return FriendshipMapper.toFriendModel(repository.getFriendship(userUuid, friendUuid));
    }

    public FriendshipModel getFriendship(UUID userUuid, UUID friendUuid) {
        return FriendshipMapper.toFriendModel(repository.getFriendship(userUuid, friendUuid));
    }
}
