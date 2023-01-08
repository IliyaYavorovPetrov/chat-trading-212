package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class FriendDto {
    public final UUID friendshipUuid;
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;

    public FriendDto(UUID friendshipUuid, UUID userUuid, String userNickname, Integer userPictureId) {
        this.friendshipUuid = friendshipUuid;
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
    }
}
