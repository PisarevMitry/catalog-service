CREATE SEQUENCE IF NOT EXISTS product_special_condition_seq;
CREATE TABLE IF NOT EXISTS "product_special_condition"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_special_condition_seq')),
    "description" TEXT                        DEFAULT NULL
);