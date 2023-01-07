package com.chattrading212.chat.controllers.dtos;

import java.time.Instant;
import java.util.UUID;

public class FriendsDto {
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;
    public final UUID friendUuid;
    public final String friendNickname;
    public final Integer friendPictureId;

    public FriendsDto(UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
        this.friendUuid = friendUuid;
        this.friendNickname = friendNickname;
        this.friendPictureId = friendPictureId;
    }
}
