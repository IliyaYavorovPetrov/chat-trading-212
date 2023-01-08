package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.FriendshipDto;
import com.chattrading212.chat.controllers.dtos.RequestFriendshipDto;
import com.chattrading212.chat.controllers.dtos.UserDto;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.models.FriendshipModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendshipController {
    private final FriendshipService friendService;

    public FriendshipController(FriendshipService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/home/getfriends")
    public ResponseEntity<List<FriendshipModel>> getFriendshipsUser(@RequestBody UserDto userDto) {
        List<FriendshipModel> friendshipModelList = friendService.getUserFriendships(userDto.userUuid);
        return ResponseEntity.ok(friendshipModelList);
    }

    @PostMapping("/home/friends")
    public ResponseEntity<FriendshipDto> createFriendship(@RequestBody RequestFriendshipDto requestFriendshipDto) {
        FriendshipModel friendsModel = friendService.createFriendship(requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId));
    }

    @PostMapping("/home/friends/delete")
    public ResponseEntity<FriendshipDto> deleteFriendship(@RequestBody FriendshipDto friendshipDto) {
        FriendshipModel friendsModel = friendService.deleteFriendship(friendshipDto.friendshipUuid);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, friendsModel.userUuid, friendsModel.userNickname, friendsModel.userPictureId, friendsModel.friendUuid, friendsModel.friendNickname, friendsModel.friendPictureId));
    }
}
