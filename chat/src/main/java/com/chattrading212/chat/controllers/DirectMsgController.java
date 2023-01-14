package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.controllers.dtos.RequestDirectMsgDto;
import com.chattrading212.chat.mappers.DirectMsgMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.MemberService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import com.chattrading212.chat.services.models.MemberModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class DirectMsgController {
    private final SimpMessagingTemplate template;
    private final DirectMsgService directMsgService;
    private final MemberService memberService;

    public DirectMsgController(DirectMsgService directMsgService, SimpMessagingTemplate template, MemberService memberService) {
        this.directMsgService = directMsgService;
        this.template = template;
        this.memberService = memberService;
    }

    @PostMapping("/home/chats")
    public ResponseEntity<Void> sendDirectMessage(@RequestBody RequestDirectMsgDto requestDirectMsgDto) {
        List<MemberModel> memberModelList = memberService.getMembersInChat(requestDirectMsgDto.chatUuid);
        directMsgService.createDirectMsg(requestDirectMsgDto.chatUuid, requestDirectMsgDto.msgText, requestDirectMsgDto.fromUserUuid, requestDirectMsgDto.fromUserNickname, requestDirectMsgDto.fromUserPictureId);
        for (var member : memberModelList) {
            List<DirectMsgModel> directMsgModelList = directMsgService.getDirectMsgsByChatUuid(member.chatUuid);
            List<DirectMsgDto> directMsgDtoList = new java.util.ArrayList<>(directMsgModelList.stream().map(DirectMsgMapper::toDirectMsgDto).toList());
            Collections.reverse(directMsgDtoList);
            template.convertAndSend("/user/" + member.memberUuid + "/private", directMsgDtoList);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/home/chats/{chatUuid}")
    public ResponseEntity<List<DirectMsgDto>> getDirectMsgsByChatUuid(@PathVariable UUID chatUuid) {
        List<DirectMsgModel> directMsgModelList = directMsgService.getDirectMsgsByChatUuid(chatUuid);
        List<DirectMsgDto> directMsgDtoList = new java.util.ArrayList<>(directMsgModelList.stream().map(DirectMsgMapper::toDirectMsgDto).toList());
        Collections.reverse(directMsgDtoList);
        return ResponseEntity.ok(directMsgDtoList);
    }
}
