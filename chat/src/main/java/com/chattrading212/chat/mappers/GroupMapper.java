package com.chattrading212.chat.mappers;

import com.chattrading212.chat.repositories.entities.GroupEntity;
import com.chattrading212.chat.services.models.GroupModel;

public class GroupMapper {
    public static GroupModel toGroupModel(GroupEntity groupEntity) {
        return new GroupModel(groupEntity.groupUuid, groupEntity.groupName, groupEntity.groupUrl);
    }
}
