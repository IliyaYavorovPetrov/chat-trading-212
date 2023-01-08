package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.FriendshipModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendshipService {
    private final FriendshipRepository repository;

    public FriendshipService(FriendshipRepository repository) {
        this.repository = repository;
    }

    public FriendshipModel createFriendship(UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        UUID friendshipUuid = UUID.randomUUID();
        return FriendshipMapper.toFriendshipModel(repository.createFriendship(friendshipUuid, userUuid, userNickname, userPictureId, friendUuid, friendNickname, friendPictureId));
    }

    public FriendshipModel getFriendship(UUID friendshipUuid) {
        return FriendshipMapper.toFriendshipModel(repository.getFriendship(friendshipUuid));
    }

    public FriendshipModel deleteFriendship(UUID friendshipUuid) {
        return FriendshipMapper.toFriendshipModel(repository.deleteFriendship(friendshipUuid));
    }

    public List<FriendshipModel> getUserFriendships(UUID userUuid) {
        List<FriendshipEntity> friendshipEntityList = repository.getUserFriendships(userUuid);
        List<FriendshipModel> friendshipModels = new ArrayList<>();

        for (var row : friendshipEntityList) {
            friendshipModels.add(FriendshipMapper.toFriendshipModel(row));
        }

        return friendshipModels;
    }
}
