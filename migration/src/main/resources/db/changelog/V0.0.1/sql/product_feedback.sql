CREATE SEQUENCE IF NOT EXISTS product_feedback_seq;
CREATE TABLE IF NOT EXISTS "product_feedback"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_feedback_seq')),
    "grade"       INTEGER            NOT NULL DEFAULT 5,
    "description" TEXT,
    "create_dttm" TIMESTAMP,
    "client_id"   BIGINT,
    "parent_id"   BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_feedback (id)

);
