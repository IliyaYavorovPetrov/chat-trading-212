package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraDirectMsgQueries {
    public static final String CREATE_DIRECT_MSG = "INSERT INTO chat.direct_msg_by_msg_uuid (msg_uuid, chat_uuid, created_at, is_deleted, msg_text, from_user_uuid, from_user_nickname, from_user_picture_id) VALUES (?, ?, system.toTimestamp(system.now()), false, ?, ?, ?, ?)";
    public static final String GET_DIRECT_MSG = "SELECT * FROM chat.direct_msg_by_msg_uuid WHERE msg_uuid=?";
}
