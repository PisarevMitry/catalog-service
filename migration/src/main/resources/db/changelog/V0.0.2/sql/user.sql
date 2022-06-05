CREATE SEQUENCE "user_seq";
CREATE TABLE "user"
(
    "id"       BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
    "email"    VARCHAR,
    "password" VARCHAR
);