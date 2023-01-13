package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.DirectMsgRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraDirectMsgQueries;
import com.chattrading212.chat.repositories.entities.DirectMsgEntity;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CassandraDirectMsgRepository implements DirectMsgRepository {
    private final CqlSession session;

    @Autowired
    public CassandraDirectMsgRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public DirectMsgEntity createDirectMsg(UUID msgUuid, UUID chatUuid, String msgText, UUID fromUserUuid, String fromUserNickname, Integer fromUserPictureId) {
        session.execute(CassandraDirectMsgQueries.CREATE_DIRECT_MSG, msgUuid, chatUuid, msgText, fromUserUuid, fromUserNickname, fromUserPictureId);
        return getDirectMsg(msgUuid);
    }

    @Override
    public DirectMsgEntity getDirectMsg(UUID msgUuid) {
        ResultSet resultSet = session.execute(CassandraDirectMsgQueries.GET_DIRECT_MSG, msgUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID directMsgEntityMsgUuid = row.getUuid("msg_uuid");
            UUID directMsgEntityChatUuid = row.getUuid("chat_uuid");
            Instant directMsgEntityCreatedAt = row.getInstant("created_at");
            Boolean directMsgEntityIsDeleted = row.getBoolean("is_deleted");
            String directMsgEntityMsgText = row.getString("msg_text");
            UUID directMsgEntityUserUuid = row.getUuid("from_user_uuid");
            String directMsgEntityUserNickname = row.getString("from_user_nickname");
            Integer directMsgEntityUserPictureId = row.getInt("from_user_picture_id");

            return new DirectMsgEntity(directMsgEntityMsgUuid, directMsgEntityChatUuid, directMsgEntityCreatedAt, directMsgEntityIsDeleted, directMsgEntityMsgText, directMsgEntityUserUuid, directMsgEntityUserNickname, directMsgEntityUserPictureId);
        }
        return null;
    }

    @Override
    public List<DirectMsgEntity> getDirectMsgByChatUuid(UUID chatUuid) {
        ResultSet resultSet = session.execute(CassandraDirectMsgQueries.GET_DIRECT_MSGS_BY_CHAT_UUID);
        List<Row> rows = resultSet.all();

        List<DirectMsgEntity> directMsgEntityList = new ArrayList<>();
        for (var row : rows) {
            UUID directMsgEntityMsgUuid = row.getUuid("msg_uuid");
            UUID directMsgEntityChatUuid = row.getUuid("chat_uuid");
            Instant directMsgEntityCreatedAt = row.getInstant("created_at");
            Boolean directMsgEntityIsDeleted = row.getBoolean("is_deleted");
            String directMsgEntityMsgText = row.getString("msg_text");
            UUID directMsgEntityUserUuid = row.getUuid("from_user_uuid");
            String directMsgEntityUserNickname = row.getString("from_user_nickname");
            Integer directMsgEntityUserPictureId = row.getInt("from_user_picture_id");
            DirectMsgEntity directMsgEntity = new DirectMsgEntity(directMsgEntityMsgUuid, directMsgEntityChatUuid, directMsgEntityCreatedAt, directMsgEntityIsDeleted, directMsgEntityMsgText, directMsgEntityUserUuid, directMsgEntityUserNickname, directMsgEntityUserPictureId);
            directMsgEntityList.add(directMsgEntity);
        }
        return directMsgEntityList;
    }
}
