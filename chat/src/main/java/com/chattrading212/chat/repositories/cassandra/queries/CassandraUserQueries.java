package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraUserQueries {
    public static final String CREATE_USER = "INSERT INTO chat.users_by_uuid (user_uuid, created_at, email, is_deleted, password, nickname, picture_id) VALUES (?, system.toTimestamp(system.now()), ?, false, ?, ?, ?)";
    public static final String GET_USER_BY_UUID = "SELECT * FROM chat.users_by_uuid WHERE user_uuid=? LIMIT 1";
    public static final String DOES_UUID_EXIST = "SELECT COUNT(*) FROM chat.users_by_uuid WHERE user_uuid=?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM chat.users_by_email WHERE email=? LIMIT 1";
    public static final String DOES_EMAIL_EXIST = "SELECT COUNT(*) FROM chat.users_by_email WHERE email=?";
    public static final String GET_USER_BY_NICKNAME = "SELECT * FROM chat.users_by_nickname WHERE nickname=?";
    public static final String DOES_NICKNAME_EXIST = "SELECT COUNT(*) FROM chat.users_by_nickname WHERE nickname=?";
    public static final String DELETE_USER_BY_UUID = "UPDATE chat.users_by_uuid SET is_deleted=true WHERE user_uuid=? IF EXISTS";
}
