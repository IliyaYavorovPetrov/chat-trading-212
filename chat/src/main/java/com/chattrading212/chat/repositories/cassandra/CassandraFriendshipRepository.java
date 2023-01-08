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
    public FriendshipEntity createFriendship(UUID friendshipUuid, UUID userUuid, String userNickname, Integer userPictureId, UUID friendUuid, String friendNickname, Integer friendPictureId) {
        session.execute(CassandraFriendshipQueries.CREATE_FRIENDSHIP, friendshipUuid, userUuid, userNickname, userPictureId, friendUuid, friendNickname, friendPictureId);
        return getFriendship(friendshipUuid);
    }

    @Override
    public FriendshipEntity deleteFriendship(UUID friendshipUuid) {
        session.execute(CassandraFriendshipQueries.DELETE_FRIENDSHIP_BY_FRIENDSHIP_UUID, friendshipUuid);
        FriendshipEntity friendshipEntity = getFriendship(friendshipUuid);
        friendshipEntity.isDeleted = Boolean.TRUE;
        return friendshipEntity;
    }

    @Override
    public FriendshipEntity getFriendship(UUID friendshipUuid) {
        ResultSet resultSet = session.execute(CassandraFriendshipQueries.GET_FRIENDSHIP_BY_FRIENDSHIP_UUID, friendshipUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID friendEntityFriendshipUuid = row.getUuid("friendship_uuid");
            Instant friendEntityCreatedAt = row.getInstant("created_at");
            Boolean friendEntityIsDeleted = row.getBoolean("is_deleted");
            UUID friendEntityUserUuid = row.getUuid("user_uuid");
            String friendEntityUserNickname = row.getString("user_nickname");
            Integer friendEntityUserPictureId = row.getInt("user_picture_id");
            UUID friendEntityFriendUuid = row.getUuid("friend_uuid");
            String friendEntityFriendNickname = row.getString("friend_nickname");
            Integer friendEntityFriendPictureId = row.getInt("friend_picture_id");

            return new FriendshipEntity(friendEntityFriendshipUuid, friendEntityCreatedAt, friendEntityIsDeleted, friendEntityUserUuid, friendEntityUserNickname, friendEntityUserPictureId, friendEntityFriendUuid, friendEntityFriendNickname, friendEntityFriendPictureId);
        }

        return null;
    }
}
