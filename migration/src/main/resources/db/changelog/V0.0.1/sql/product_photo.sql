CREATE SEQUENCE IF NOT EXISTS product_photo_seq;
CREATE TABLE IF NOT EXISTS "product_photo"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_photo_seq')),
    "url"       VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_photo (id)
);