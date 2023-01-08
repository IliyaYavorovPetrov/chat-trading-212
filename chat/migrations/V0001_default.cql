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
primary key ( (friend_uuid), friendship_uuid )