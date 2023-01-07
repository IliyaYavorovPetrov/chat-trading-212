package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraFriendsQueries {
    public static final String CREATE_FRIENDSHIP = "INSERT INTO chat.friends_by_uuid (user_uuid, created_at, is_deleted, friend_uuid, friend_nickname, friend_picture_id) VALUES (?, system.toTimestamp(system.now()), false, ?, ?, ?)";
    public static final String GET_USER_BY_USER_UUID = "SELECT * FROM chat.friends_by_uuid WHERE user_uuid=? AND friend_uuid=? LIMIT 1";
}
