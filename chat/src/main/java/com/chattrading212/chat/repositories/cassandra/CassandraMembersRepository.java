package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.MembersRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraMembersQueries;
import com.chattrading212.chat.repositories.entities.MemberEntity;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CassandraMembersRepository implements MembersRepository {
    private final CqlSession session;

    public CassandraMembersRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public MemberEntity createMember(UUID connectionUuid, UUID chatUuid, UUID memberUuid) {
        session.execute(CassandraMembersQueries.CREATE_MEMBERSHIP, connectionUuid, chatUuid, memberUuid);
        return getMembershipByConnectionUuid(connectionUuid);
    }

    @Override
    public MemberEntity getMembershipByConnectionUuid(UUID connectionUuid) {
        ResultSet resultSet = session.execute(CassandraMembersQueries.GEt_MEMBERSHIP_BY_CONNECTION_UUID, connectionUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID memberConnectionUuid = row.getUuid("connection_uuid");
            UUID memberChatUuid = row.getUuid("chat_uuid");
            UUID memberMemberUuid = row.getUuid("member_uuid");

            return new MemberEntity(memberConnectionUuid, memberChatUuid, memberMemberUuid);
        }
        return null;
    }

    @Override
    public List<MemberEntity> getMembersInChat(UUID chatUuid) {
        ResultSet resultSet = session.execute(CassandraMembersQueries.GET_MEMBERSHIP_BY_CHAT_UUID, chatUuid);
        List<Row> rows = resultSet.all();

        List<MemberEntity> memberEntityList = new ArrayList<>();
        for (var row : rows) {
            MemberEntity memberEntity = getMembershipByConnectionUuid(row.getUuid("connection_uuid"));
            memberEntityList.add(memberEntity);
        }

        return memberEntityList;
    }

    @Override
    public List<MemberEntity> getChatsByMember(UUID memberUuid) {
        ResultSet resultSet = session.execute(CassandraMembersQueries.GET_CHAT_BY_MEMBER_UUID, memberUuid);
        List<Row> rows = resultSet.all();

        List<MemberEntity> memberEntityList = new ArrayList<>();
        for (var row : rows) {
            MemberEntity memberEntity = getMembershipByConnectionUuid(row.getUuid("connection_uuid"));
            memberEntityList.add(memberEntity);
        }

        return memberEntityList;
    }
}
