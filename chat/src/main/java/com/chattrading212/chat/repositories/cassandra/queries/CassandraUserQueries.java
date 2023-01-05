package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraUserQueries {
    public static final String CREATE_USER = "INSERT INTO chat.users_by_uuid (user_uuid, created_at, email, is_deleted, password, nickname) VALUES (uuid(), system.toTimestamp(system.now()), ?, false, ?, ?)";
    public static final String GET_USER_BY_UUID = "SELECT * FROM chat.users_by_uuid WHERE user_uuid=? LIMIT 1";
    public static final String DOES_UUID_EXIST = "SELECT COUNT(*) FROM chat.users_by_uuid WHERE user_uuid=?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM chat.users_by_email WHERE email=? LIMIT 1";
    public static final String DOES_EMAIL_EXIST = "SELECT COUNT(*) FROM chat.users_by_email WHERE email=?";
//    public static final String GET_USER_BY_UUID = "SELECT * FROM chat.users_by_uuid WHERE user_uuid=?";
//    public static final String DOES_UUID_EXIST = "SELECT COUNT(*) FROM chat.users_by_uuid WHERE user_uuid=?";
}
