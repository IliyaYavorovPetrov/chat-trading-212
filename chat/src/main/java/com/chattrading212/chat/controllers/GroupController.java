package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.GroupService;
import com.chattrading212.chat.services.MemberService;
import com.chattrading212.chat.services.UserService;
import com.chattrading212.chat.services.models.FriendshipModel;
import com.chattrading212.chat.services.models.GroupModel;
import com.chattrading212.chat.services.models.MemberModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GroupController {
    private final SimpMessagingTemplate template;
    private final GroupService groupService;
    private final UserService userService;
    private final DirectMsgService directMsgService;
    private final MemberService memberService;

    public GroupController(SimpMessagingTemplate template, GroupService groupService, UserService userService, DirectMsgService directMsgService, MemberService memberService) {
        this.template = template;
        this.groupService = groupService;
        this.userService = userService;
        this.directMsgService = directMsgService;
        this.memberService = memberService;
    }

    @PostMapping("/home/groups/create")
    public ResponseEntity<Void> createGroup(@RequestBody RequestGroupDto requestGroupDto) {
        GroupModel groupModel = groupService.createGroup(requestGroupDto.groupName, requestGroupDto.groupUrl);
        directMsgService.createDirectMsg(groupModel.groupUuid, "Hello everyone!", requestGroupDto.userUuid, requestGroupDto.userNickname, requestGroupDto.userPictureId);
        memberService.createMember(groupModel.groupUuid, requestGroupDto.userUuid);

        List<GroupDto> groupDtoList = new ArrayList<>();

        List<MemberModel> memberModelList = memberService.getChatsByMember(requestGroupDto.userUuid);
        for (var x : memberModelList) {
            try {
                GroupModel groupModel1 = groupService.getGroupByGroupUuid(x.chatUuid);
                groupDtoList.add(new GroupDto(groupModel1.groupUuid, groupModel1.groupName, groupModel1.groupUrl));
            }
            catch (Exception ex) {

            }
        }
        template.convertAndSend("/user/" + requestGroupDto.userUuid + "/private", groupDtoList);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/home/groups/add")
    public ResponseEntity<Void> addToGroup(@RequestBody RequestAddToGroupDto requestAddToGroupDto) {
        memberService.createMember(requestAddToGroupDto.groupUuid, requestAddToGroupDto.userUuid);
        List<MemberModel> memberModelList = memberService.getMembersInChat(requestAddToGroupDto.groupUuid);
        List<FriendDto> userDtoList = new ArrayList<>();
        for (var x : memberModelList) {
            UserDto userDto = UserMapper.toUserDto(userService.getByUUID(x.memberUuid));
            FriendDto friendDto = new FriendDto(x.chatUuid, userDto.userUuid, userDto.nickname, userDto.pictureId);
            userDtoList.add(friendDto);
        }
        for (var x : memberModelList) {
            template.convertAndSend("/user/" + x.memberUuid + "/private", userDtoList);
        }

        List<GroupDto> groupDtoList = new ArrayList<>();

        List<MemberModel> a = memberService.getChatsByMember(requestAddToGroupDto.userUuid);
        GroupModel groupModel1 = groupService.getGroupByGroupUuid(a.get(0).chatUuid);
        groupDtoList.add(new GroupDto(groupModel1.groupUuid, groupModel1.groupName, groupModel1.groupUrl));
        template.convertAndSend("/user/" + requestAddToGroupDto.userUuid + "/private", groupDtoList);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/home/groups/{uuid}")
    public ResponseEntity<List<GroupDto>> getGroupsByUserUuid(@PathVariable UUID uuid) {
        List<GroupDto> groupDtoList = new ArrayList<>();

        List<MemberModel> memberModelList = memberService.getChatsByMember(uuid);
        for (var x : memberModelList) {
            try {
                GroupModel groupModel = groupService.getGroupByGroupUuid(x.chatUuid);
                groupDtoList.add(new GroupDto(groupModel.groupUuid, groupModel.groupName, groupModel.groupUrl));
            }
            catch (Exception ex) {

            }
        }

        return ResponseEntity.ok(groupDtoList);
    }

    @GetMapping("/home/groups/users/{groupUuid}")
    public ResponseEntity<List<FriendDto>> getUsersInGroup(@PathVariable UUID groupUuid) {
       List<FriendDto> userDtoList = new ArrayList<>();
       List<MemberModel> memberModelList = memberService.getMembersInChat(groupUuid);
       for (var x : memberModelList) {
           UserDto userDto = UserMapper.toUserDto(userService.getByUUID(x.memberUuid));
           FriendDto friendDto = new FriendDto(groupUuid, userDto.userUuid, userDto.nickname, userDto.pictureId);
           userDtoList.add(friendDto);
       }

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/home/add/group/nickname/{nickname}/{uuid}/{groupUuid}")
    public ResponseEntity<List<UserDto>> getUserByNickname(@PathVariable String nickname, @PathVariable UUID uuid, @PathVariable UUID groupUuid) {
        List<UserDto> usersDto = userService.getByNickname(nickname).stream().map(UserMapper::toUserDto).toList();
        List<MemberModel> memberModelList = memberService.getMembersInChat(groupUuid);

        List<UserDto> answ = new ArrayList<>();
        for (var x : usersDto) {
            Boolean foo = false;
            for (var y : memberModelList) {
                if (x.userUuid.equals(y.memberUuid)) {
                    foo = true;
                    break;
                }
            }
            if (!foo) {
                answ.add(x);
            }
        }

        return ResponseEntity.ok(answ);
    }
}
