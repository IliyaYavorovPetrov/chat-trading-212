package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraFriendshipQueries;
import com.chattrading212.chat.repositories.entities.FriendshipEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import com.datastax.oss.driver.api.core.cql.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.UUID;

public class CassandraFriendshipRepository implements FriendshipRepository {

    private final CqlSession session;

    @Autowired
    public CassandraFriendshipRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public void createFriendship(UUID userUuid, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        session.execute(CassandraFriendshipQueries.CREATE_FRIENDSHIP, userUuid, friendUuid, friendNickname, friendPictureId);
    }

    @Override
    public void deleteFriendship(UUID userUuid, UUID friendUuid) {

    }

    @Override
    public FriendshipEntity getFriendship(UUID userUuid, UUID friendUuid) {
        ResultSet resultSet = session.execute(CassandraFriendshipQueries.GET_USER_BY_USER_UUID, userUuid, friendUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID friendEntityUserUuid = row.getUuid("user_uuid");
            Instant friendEntityCreatedAt = row.getInstant("created_at");
            Boolean friendEntityIsDeleted = row.getBoolean("is_deleted");
            UUID friendEntityFriendUuid = row.getUuid("friend_uuid");
            String friendEntityFriendNickname = row.getString("friend_nickname");
            Integer friendEntityFriendPictureId = row.getInt("friend_picture_id");

            return new FriendshipEntity(friendEntityUserUuid, friendEntityCreatedAt, friendEntityIsDeleted, friendEntityFriendUuid, friendEntityFriendNickname, friendEntityFriendPictureId);
        }

        return null;
    }
}
