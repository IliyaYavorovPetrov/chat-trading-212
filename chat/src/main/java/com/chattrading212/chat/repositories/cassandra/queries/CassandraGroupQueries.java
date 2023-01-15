package com.chattrading212.chat.repositories.cassandra.queries;

public class CassandraGroupQueries {
    public static final String CREATE_GROUP = "INSERT INTO chat.groups_by_group_uuid (group_uuid, group_name, group_url) VALUES (?, ?, ?)";
    public static final String GET_GROUP_BY_GROUP_UUID = "SELECT * from chat.groups_by_group_uuid WHERE group_uuid=?";
}
