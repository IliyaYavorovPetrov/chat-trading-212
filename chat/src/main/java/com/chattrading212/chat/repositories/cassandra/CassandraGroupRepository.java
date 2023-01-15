package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.GroupRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraFriendshipQueries;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraGroupQueries;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.chattrading212.chat.repositories.entities.GroupEntity;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.UUID;

public class CassandraGroupRepository implements GroupRepository {
    private final CqlSession session;

    @Autowired
    public CassandraGroupRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public GroupEntity createGroup(UUID groupUuid, String groupName, String groupUrl) {
        session.execute(CassandraGroupQueries.CREATE_GROUP, groupUuid, groupName, groupUrl);
        return getGroupByGroupUuid(groupUuid);
    }

    @Override
    public GroupEntity getGroupByGroupUuid(UUID groupUuid) {
        ResultSet resultSet = session.execute(CassandraGroupQueries.GET_GROUP_BY_GROUP_UUID, groupUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID groupEntityGroupUuid = row.getUuid("group_uuid");
            String groupEntityGroupName = row.getString("group_name");
            String groupEntityGroupUrl = row.getString("group_url");

            return new GroupEntity(groupEntityGroupUuid, groupEntityGroupName, groupEntityGroupUrl);
        }

        return null;
    }
}
