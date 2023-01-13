package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.MemberEntity;
import com.chattrading212.chat.services.models.MemberModel;

public class MembersMapper {
    public static MemberModel toMemberModel(MemberEntity memberEntity) {
        return new MemberModel(memberEntity.connectionUuid, memberEntity.chatUuid, memberEntity.memberUuid);
    }
}
