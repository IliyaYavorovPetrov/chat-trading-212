CREATE TABLE IF NOT EXISTS users_by_nickname (
    user_uuid uuid,
    nickname text,
    created_at timestamp,
    password text,
    username text,
    PRIMARY KEY ( (user_uuid), nickname)
);