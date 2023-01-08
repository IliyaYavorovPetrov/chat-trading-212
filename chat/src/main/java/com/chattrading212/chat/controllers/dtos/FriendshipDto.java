package com.chattrading212.chat.controllers.dtos;

import java.util.UUID;

public class FriendshipDto {
    public final UUID friendshipUuid;
    public final Boolean isDelted;
    public final UUID userUuid;
    public final String userNickname;
    public final Integer userPictureId;
    public final UUID friendUuid;
    public final String friendNickname;
    public final Integer friendPictureId;

    public FriendshipDto(UUID friendshipUuid, Boolean isDelted, UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        this.friendshipUuid = friendshipUuid;
        this.isDelted = isDelted;
        this.userUuid = userUuid;
        this.userNickname = userNickname;
        this.userPictureId = userPictureId;
        this.friendUuid = friendUuid;
        this.friendNickname = friendNickname;
        this.friendPictureId = friendPictureId;
    }
}
