create table chat.users_by_uuid
(
    user_uuid  uuid primary key,
    created_at timestamp,
    email      text,
    is_deleted boolean,
    nickname   text,
    password   text,
    picture_id int,
);

create materialized view chat.users_by_email
as select user_uuid, created_at, email, is_deleted, nickname, password, picture_id
    from chat.users_by_uuid
    where user_uuid is not null and email is not null
primary key ( (email), user_uuid );

create materialized view chat.users_by_nickname
as select user_uuid, created_at, email, is_deleted, nickname, password, picture_id
    from chat.users_by_uuid
    where user_uuid is not null and nickname is not null
primary key ( (nickname), user_uuid );

create table chat.friends_by_friendship_uuid
(
  friendship_uuid uuid primary key,
  created_at timestamp,
  is_deleted boolean,
  user_uuid uuid,
  user_nickname text,
  user_picture_id int,
  friend_uuid uuid,
  friend_nickname text,
  friend_picture_id int,
);

create materialized view chat.friends_by_user_uuid
as select friendship_uuid, created_at, is_deleted, user_uuid, user_nickname, user_picture_id, friend_uuid, friend_nickname, friend_picture_id
   from chat.friends_by_friendship_uuid
   where friendship_uuid is not null and user_uuid is not null
primary key ( (user_uuid), friendship_uuid );

create materialized view chat.friends_by_friend_uuid
as select friendship_uuid, created_at, is_deleted, user_uuid, user_nickname, user_picture_id, friend_uuid, friend_nickname, friend_picture_id
    from chat.friends_by_friendship_uuid
    where friendship_uuid is not null and friend_uuid is not null
primary key ( (friend_uuid), friendship_uuid );

create table chat.direct_msg_by_msg_uuid
(
    msg_uuid timeuuid primary key,
    chat_uuid uuid,
    created_at timestamp,
    is_deleted boolean,
    msg_text text,
    from_user_uuid uuid,
    from_user_nickname text,
    from_user_picture_id int,
);

create materialized view chat.direct_msg_by_chat_uuid
as select msg_uuid, chat_uuid, created_at, is_deleted, from_user_uuid, from_user_nickname, from_user_picture_id, msg_text
   from chat.direct_msg_by_msg_uuid
   where msg_uuid is not null and chat_uuid is not null
primary key ( (chat_uuid), msg_uuid ) with clustering order by (msg_uuid desc);

create table chat.members_by_connection_uuid
(
    connection_uuid uuid primary key,
    chat_uuid uuid,
    member_uuid uuid,
);

create materialized view chat.members_by_chat_uuid
as select connection_uuid, chat_uuid, member_uuid
    from chat.members_by_connection_uuid
    where connection_uuid is not null and chat_uuid is not null and member_uuid is not null
primary key ( (chat_uuid),  connection_uuid);

create materialized view chat.members_by_member_uuid
as select connection_uuid, chat_uuid, member_uuid
   from chat.members_by_connection_uuid
   where connection_uuid is not null and chat_uuid is not null and member_uuid is not null
primary key ( (member_uuid),  connection_uuid);

create table chat.groups_by_group_uuid
(
    group_uuid uuid primary key,
    group_name text,
    group_url text,
);

