package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.DirectMsgMapper;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.GroupService;
import com.chattrading212.chat.services.MemberService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import com.chattrading212.chat.services.models.GroupModel;
import com.chattrading212.chat.services.models.MemberModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class GroupController {
    private final SimpMessagingTemplate template;
    private final GroupService groupService;
    private final DirectMsgService directMsgService;
    private final MemberService memberService;

    public GroupController(SimpMessagingTemplate template, GroupService groupService, DirectMsgService directMsgService, MemberService memberService) {
        this.template = template;
        this.groupService = groupService;
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
            GroupModel groupModel1 = groupService.getGroupByGroupUuid(x.chatUuid);
            groupDtoList.add(new GroupDto(groupModel1.groupUuid, groupModel1.groupName, groupModel1.groupUrl));
        }
        template.convertAndSend("/user/" + requestGroupDto.userUuid + "/private", groupDtoList);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/home/groups/{uuid}")
    public ResponseEntity<List<GroupDto>> getUserByUuid(@PathVariable UUID uuid) {
        List<GroupDto> groupDtoList = new ArrayList<>();

        List<MemberModel> memberModelList = memberService.getChatsByMember(uuid);
        for (var x : memberModelList) {
            GroupModel groupModel = groupService.getGroupByGroupUuid(x.chatUuid);
            groupDtoList.add(new GroupDto(groupModel.groupUuid, groupModel.groupName, groupModel.groupUrl));
        }

        return ResponseEntity.ok(groupDtoList);
    }
}
