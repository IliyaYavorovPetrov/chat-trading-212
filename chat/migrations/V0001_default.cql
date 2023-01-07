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
primary key ( (email ), user_uuid );

create materialized view chat.users_by_nickname
as select user_uuid, created_at, email, is_deleted, nickname, password, picture_id
    from chat.users_by_uuid
    where user_uuid is not null and nickname is not null
primary key ( (nickname ), user_uuid );

create table chat.friends_by_uuid
(
  user_uuid uuid,
  created_at timestamp,
  is_deleted boolean,
  friend_uuid uuid,
  friend_nickname text,
  friend_picture_id int,
  primary key ( (user_uuid), friend_uuid )
);