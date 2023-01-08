package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.FriendshipModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendshipService {
    private final FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository repository) {
        this.friendshipRepository = repository;
    }

    public FriendshipModel createFriendship(UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        UUID friendshipUuid = UUID.randomUUID();
        return FriendshipMapper.toFriendshipModel(friendshipRepository.createFriendship(friendshipUuid, userUuid, userNickname, userPictureId, friendUuid, friendNickname, friendPictureId));
    }

    public FriendshipModel getFriendship(UUID friendshipUuid) {
        return FriendshipMapper.toFriendshipModel(friendshipRepository.getFriendship(friendshipUuid));
    }

    public FriendshipModel deleteFriendship(UUID friendshipUuid) {
        return FriendshipMapper.toFriendshipModel(friendshipRepository.deleteFriendship(friendshipUuid));
    }

    public List<FriendshipModel> getUserFriendships(UUID userUuid) {
        List<FriendshipEntity> friendshipEntityList = friendshipRepository.getUserFriendships(userUuid);
        List<FriendshipModel> friendshipModels = new ArrayList<>();

        for (var row : friendshipEntityList) {
            friendshipModels.add(FriendshipMapper.toFriendshipModel(row));
        }

        return friendshipModels;
    }
}
