create table chat.users_by_uuid
(
    user_uuid  uuid primary key,
    created_at timestamp,
    email      text,
    is_deleted boolean,
    nickname   text,
    password   text
);

create materialized view chat.users_by_email
as select user_uuid, created_at, email, is_deleted, nickname, password
    from chat.users_by_uuid
    where user_uuid is not null and email is not null
primary key ( (user_uuid), email );

create materialized view chat.users_by_nickname
as select user_uuid, created_at, email, is_deleted, nickname, password
    from chat.users_by_uuid
    where user_uuid is not null and nickname is not null
primary key ( (user_uuid), nickname );