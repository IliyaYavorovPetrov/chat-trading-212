package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.FriendDto;
import com.chattrading212.chat.controllers.dtos.FriendshipDto;
import com.chattrading212.chat.controllers.dtos.RequestFriendshipDto;
import com.chattrading212.chat.controllers.dtos.UserDto;
import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.services.DirectMsgService;
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
    private final DirectMsgService directMsgService;

    public FriendshipController(FriendshipService friendService, DirectMsgService directMsgService) {
        this.friendService = friendService;
        this.directMsgService = directMsgService;
    }

    @GetMapping("/home/getfriends")
    public ResponseEntity<List<FriendDto>> getFriendshipsUser(@RequestBody UserDto userDto) {
        List<FriendshipModel> friendshipModelList = friendService.getUserFriendships(userDto.userUuid);
        List<FriendDto> friendDtoList = friendshipModelList.stream().map(x -> FriendshipMapper.toFriendDto(x, userDto.userUuid)).toList();
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
