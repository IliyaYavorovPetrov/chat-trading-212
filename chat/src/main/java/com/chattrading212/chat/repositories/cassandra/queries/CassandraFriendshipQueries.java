package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraFriendshipQueries {
    public static final String CREATE_FRIENDSHIP = "INSERT INTO chat.friends_by_uuid (user_uuid, created_at, is_deleted, friend_uuid, friend_nickname, friend_picture_id) VALUES (?, system.toTimestamp(system.now()), false, ?, ?, ?)";
    public static final String GET_USER_BY_USER_UUID = "SELECT * FROM chat.friends_by_uuid WHERE user_uuid=? AND friend_uuid=? LIMIT 1";
    public static final String DELETE_FRIENDSHIP_USER_UUID = "UPDATE chat.friends_by_uuid SET is_deleted=true WHERE user_uuid=? IF EXISTS";
    public static final String DELETE_FRIENDSHIP_FRIEND_UUID = "UPDATE chat.friends_by_friend_uuid SET is_deleted=true WHERE user_uuid=? IF EXISTS";
}
