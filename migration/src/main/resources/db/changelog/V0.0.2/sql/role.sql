CREATE SEQUENCE "role_seq";
CREATE TABLE "role"
(
    "id"   BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
    "name" VARCHAR            NOT NULL
);
