package com.chattrading212.chat.repositories.entities;

import java.util.UUID;

public class MemberEntity {
    public final UUID connectionUuid;
    public final UUID chatUuid;
    public final UUID memberUuid;

    public MemberEntity(UUID connectionUuid, UUID chatUuid, UUID memberUuid) {
        this.connectionUuid = connectionUuid;
        this.chatUuid = chatUuid;
        this.memberUuid = memberUuid;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "connectionUuid=" + connectionUuid +
                ", chatUuid=" + chatUuid +
                ", memberUuid=" + memberUuid +
                '}';
    }
}
