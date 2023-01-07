package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.FriendsMapper;
import com.chattrading212.chat.repositories.FriendsRepository;
import com.chattrading212.chat.services.models.FriendsModel;

import java.util.UUID;

public class FriendService {
    private final FriendsRepository repository;

    public FriendService(FriendsRepository repository) {
        this.repository = repository;
    }

    public FriendsModel createFriendship(UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        repository.createFriendship(userUuid, friendUuid, friendNickname, friendPictureId);
        repository.createFriendship(friendUuid, userUuid, userNickname, userPictureId);
        return FriendsMapper.toFriendModel(repository.getFriendship(userUuid, friendUuid));
    }

    public FriendsModel getFriendship(UUID userUuid, UUID friendUuid) {
        return FriendsMapper.toFriendModel(repository.getFriendship(userUuid, friendUuid));
    }
}
