package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.models.FriendshipModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FriendshipController {
    private final FriendshipService friendService;
    private final DirectMsgService directMsgService;

    public FriendshipController(FriendshipService friendService, DirectMsgService directMsgService) {
        this.friendService = friendService;
        this.directMsgService = directMsgService;
    }

    @GetMapping("/home/friends/get/{uuid}")
    public ResponseEntity<List<FriendDto>> getFriendshipsUser(@PathVariable UUID uuid) {
        List<FriendshipModel> friendshipModelList = friendService.getUserFriendships(uuid);
        List<FriendDto> friendDtoList = friendshipModelList.stream().map(x -> FriendshipMapper.toFriendDto(x, uuid)).toList();
        return ResponseEntity.ok(friendDtoList);
    }

    @PostMapping("/home/friends")
    public ResponseEntity<FriendshipDto> createFriendship(@RequestBody RequestFriendshipDto requestFriendshipDto) {
        FriendshipModel friendsModel = friendService.createFriendship(requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId);
        directMsgService.createDirectMsg(friendsModel.friendshipUuid, "Hi", friendsModel.userUuid, friendsModel.userNickname, friendsModel.userPictureId);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId));
    }

    @PostMapping("/home/friends/delete")
    public ResponseEntity<FriendshipDto> deleteFriendship(@RequestBody FriendshipDto friendshipDto) {
        FriendshipModel friendsModel = friendService.deleteFriendship(friendshipDto.friendshipUuid);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, friendsModel.userUuid, friendsModel.userNickname, friendsModel.userPictureId, friendsModel.friendUuid, friendsModel.friendNickname, friendsModel.friendPictureId));
    }
}
