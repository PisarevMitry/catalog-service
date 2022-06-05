CREATE SEQUENCE IF NOT EXISTS product_category_seq;
CREATE TABLE IF NOT EXISTS "product_category"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_category_seq')),
    "title"     VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_category (id)
);
