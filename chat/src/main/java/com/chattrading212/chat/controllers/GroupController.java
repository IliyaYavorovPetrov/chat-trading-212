package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.controllers.dtos.GroupDto;
import com.chattrading212.chat.controllers.dtos.RequestDirectMsgDto;
import com.chattrading212.chat.controllers.dtos.RequestGroupDto;
import com.chattrading212.chat.mappers.DirectMsgMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.GroupService;
import com.chattrading212.chat.services.MemberService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import com.chattrading212.chat.services.models.GroupModel;
import com.chattrading212.chat.services.models.MemberModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        groupDtoList.add(new GroupDto(groupModel.groupUuid, groupModel.groupName, groupModel.groupUrl));
        template.convertAndSend("/user/" + requestGroupDto.userUuid + "/private", groupDtoList);
//        List<MemberModel> memberModelList = memberService.getMembersInChat(groupModel.groupUuid);
//        for (var member : memberModelList) {
//            List<DirectMsgModel> directMsgModelList = directMsgService.getDirectMsgsByChatUuid(member.chatUuid);
//            List<DirectMsgDto> directMsgDtoList = new java.util.ArrayList<>(directMsgModelList.stream().map(DirectMsgMapper::toDirectMsgDto).toList());
//            Collections.reverse(directMsgDtoList);
//            template.convertAndSend("/user/" + member.memberUuid + "/private", directMsgDtoList);
//        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
