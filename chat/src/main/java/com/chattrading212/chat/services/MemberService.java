package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.MembersMapper;
import com.chattrading212.chat.repositories.MembersRepository;
import com.chattrading212.chat.repositories.entities.MemberEntity;
import com.chattrading212.chat.services.models.MemberModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemberService {
    private final MembersRepository membersRepository;

    public MemberService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public MemberModel createMember(UUID chatUuid, UUID memberUuid) {
        UUID connectionUuid = UUID.randomUUID();
        return MembersMapper.toMemberModel(membersRepository.createMember(connectionUuid, chatUuid, memberUuid));
    }

    public MemberModel getMembershipByConnectionUuid(UUID connectionUuid) {
        return MembersMapper.toMemberModel(membersRepository.getMembershipByConnectionUuid(connectionUuid));
    }

    public List<MemberModel> getMembersInChat(UUID chatUuid) {
        return membersRepository.getMembersInChat(chatUuid).stream().map(MembersMapper::toMemberModel).toList();
    }
}
