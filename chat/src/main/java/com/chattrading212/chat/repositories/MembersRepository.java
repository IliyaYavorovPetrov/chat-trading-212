package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.MemberEntity;

import java.util.List;
import java.util.UUID;

public interface MembersRepository {
    MemberEntity createMember(UUID connectionUuid, UUID chatUuid, UUID memberUuid);
    MemberEntity getMembershipByConnectionUuid(UUID connectionUuid);
    List<MemberEntity> getMembersInChat(UUID chatUuid);
    List<MemberEntity> getChatsByMember(UUID memberUuid);
}
