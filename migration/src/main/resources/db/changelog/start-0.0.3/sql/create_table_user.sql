CREATE SEQUENCE "user_seq";
CREATE TABLE "user"
(
    "id"       BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
    "email"    VARCHAR,
    "password" VARCHAR
);

CREATE SEQUENCE "role_seq";
CREATE TABLE "role"
(
    "id"   BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
    "name" VARCHAR            NOT NULL
);

CREATE TABLE "user_role"
(
    "user_id" BIGINT NOT NULL,
    "role_id" BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES "role" (id),
    UNIQUE (user_id, role_id)
);