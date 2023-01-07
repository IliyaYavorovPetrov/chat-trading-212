package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.FriendsRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraFriendsQueries;
import com.chattrading212.chat.repositories.entities.FriendsEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import com.datastax.oss.driver.api.core.cql.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.UUID;

public class CassandraFriendsRepository implements FriendsRepository {

    private final CqlSession session;

    @Autowired
    public CassandraFriendsRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public void createFriendship(UUID userUuid, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        session.execute(CassandraFriendsQueries.CREATE_FRIENDSHIP, userUuid, friendUuid, friendNickname, friendPictureId);
    }

    @Override
    public void deleteFriendship(UUID userUuid, UUID friendUuid) {

    }

    @Override
    public FriendsEntity getFriendship(UUID userUuid, UUID friendUuid) {
        ResultSet resultSet = session.execute(CassandraFriendsQueries.GET_USER_BY_USER_UUID, userUuid, friendUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID friendEntityUserUuid = row.getUuid("user_uuid");
            Instant friendEntityCreatedAt = row.getInstant("created_at");
            Boolean friendEntityIsDeleted = row.getBoolean("is_deleted");
            UUID friendEntityFriendUuid = row.getUuid("friend_uuid");
            String friendEntityFriendNickname = row.getString("friend_nickname");
            Integer friendEntityFriendPictureId = row.getInt("friend_picture_id");

            return new FriendsEntity(friendEntityUserUuid, friendEntityCreatedAt, friendEntityIsDeleted, friendEntityFriendUuid, friendEntityFriendNickname, friendEntityFriendPictureId);
        }

        return null;
    }
}
