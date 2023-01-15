package com.chattrading212.chat.services;

import com.chattrading212.chat.mappers.GroupMapper;
import com.chattrading212.chat.repositories.GroupRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraGroupQueries;
import com.chattrading212.chat.repositories.entities.GroupEntity;
import com.chattrading212.chat.services.models.GroupModel;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.util.UUID;

public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupModel createGroup(String groupName, String groupUrl) {
        UUID groupUuid = UUID.randomUUID();
        return GroupMapper.toGroupModel(groupRepository.createGroup(groupUuid, groupName, groupUrl));
    }

    public GroupModel getGroupByGroupUuid(UUID groupUuid) {
        return GroupMapper.toGroupModel(groupRepository.getGroupByGroupUuid(groupUuid));
    }
}
