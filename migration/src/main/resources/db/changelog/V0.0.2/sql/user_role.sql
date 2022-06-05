CREATE TABLE "user_role"
(
    "user_id" BIGINT NOT NULL,
    "role_id" BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES "role" (id),
    UNIQUE (user_id, role_id)
);