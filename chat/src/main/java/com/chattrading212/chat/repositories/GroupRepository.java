package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.GroupEntity;

import java.util.UUID;

public interface GroupRepository {
    GroupEntity createGroup(UUID groupUuid, String groupName, String groupUrl);
    GroupEntity getGroupByGroupUuid(UUID groupUuid);
}
