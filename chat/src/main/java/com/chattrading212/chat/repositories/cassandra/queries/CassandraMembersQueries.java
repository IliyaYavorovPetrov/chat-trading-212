package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraMembersQueries {
    public static final String CREATE_MEMBERSHIP = "INSERT INTO chat.members_by_connection_uuid (connection_uuid, chat_uuid, member_uuid) VALUES (?, ?, ?)";
    public static final String GEt_MEMBERSHIP_BY_CONNECTION_UUID = "SELECT * FROM chat.members_by_connection_uuid WHERE connection_uuid=?";
    public static final String GET_MEMBERSHIP_BY_CHAT_UUID = "SELECT * FROM chat.members_by_chat_uuid WHERE chat_uuid=?";
}
