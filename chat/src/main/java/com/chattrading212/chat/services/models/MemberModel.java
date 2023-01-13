package com.chattrading212.chat.services.models;

import java.util.UUID;

public class MemberModel {
    public final UUID connectionUuid;
    public final UUID chatUuid;
    public final UUID memberUuid;

    public MemberModel(UUID connectionUuid, UUID chatUuid, UUID memberUuid) {
        this.connectionUuid = connectionUuid;
        this.chatUuid = chatUuid;
        this.memberUuid = memberUuid;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "connectionUuid=" + connectionUuid +
                ", chatUuid=" + chatUuid +
                ", memberUuid=" + memberUuid +
                '}';
    }
}
