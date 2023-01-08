package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraFriendshipQueries {
    public static final String CREATE_FRIENDSHIP = "INSERT INTO chat.friends_by_friendship_uuid (friendship_uuid, created_at, is_deleted, user_uuid, user_nickname, user_picture_id, friend_uuid, friend_nickname, friend_picture_id) VALUES (?, system.toTimestamp(system.now()), false, ?, ?, ?, ?, ?, ?)";
    public static final String GET_FRIENDSHIP_BY_FRIENDSHIP_UUID = "SELECT * FROM chat.friends_by_friendship_uuid WHERE friendship_uuid=? LIMIT 1";
    public static final String GET_FRIENDS_BY_USER_UUID = "SELECT * FROM chat.friends_by_user_uuid WHERE user_uuid=?";
    public static final String GET_FRIENDS_BY_FRIEND_UUID = "SELECT * FROM chat.friends_by_friend_uuid WHERE friend_uuid=?";
    public static final String DELETE_FRIENDSHIP_BY_FRIENDSHIP_UUID = "UPDATE chat.friends_by_friendship_uuid SET is_deleted=true WHERE friendship_uuid=? IF EXISTS";
}
