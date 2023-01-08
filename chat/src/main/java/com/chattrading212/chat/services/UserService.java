package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.services.models.UserModel;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    public UserService(UserRepository repository, FriendshipRepository friendshipRepository) {
        this.userRepository = repository;
        this.friendshipRepository = friendshipRepository;
    }

    public UserModel getByUUID(UUID userUuid) {
        return UserMapper.toUserModel(userRepository.getByUUID(userUuid));
    }
    public Boolean doesUUIDExists(UUID userUuid) {
        return userRepository.doesUUIDExists(userUuid);
    }
    public UserModel getByEmail(String email) {
        return UserMapper.toUserModel(userRepository.getByEmail(email));
    }
    public Boolean doesEmailExists(String email) {
        return userRepository.doesEmailExists(email);
    }

    public UserModel deleteUser(UUID userUuid) {
        UserModel userModel = UserMapper.toUserModel(userRepository.deleteUser(userUuid));
        List<FriendshipEntity> friendshipEntityList = friendshipRepository.getUserFriendships(userUuid);
        for (var friendship : friendshipEntityList) {
            friendshipRepository.deleteFriendship(friendship.friendshipUuid);
        }
        return userModel;
    }
}
