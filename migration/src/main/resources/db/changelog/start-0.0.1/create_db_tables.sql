CREATE TYPE "available_payment_method" AS ENUM (
    'card',
    'online wallet',
    'cash'
    );

CREATE TYPE "available_payment_status" AS ENUM (
    'not successful',
    'successfully'
    );

CREATE TYPE "available_delivery_method" AS ENUM (
    'pickup',
    'delivery'
    );

CREATE TYPE "available_delivery_status" AS ENUM (
    'going to stock',
    'received'
    );

CREATE SEQUENCE IF NOT EXISTS payment_method_seq;
CREATE TABLE IF NOT EXISTS "payment_method"
(
    "id"      BIGINT PRIMARY KEY       NOT NULL DEFAULT (nextval('payment_method_seq')),
    "method"  AVAILABLE_PAYMENT_METHOD NOT NULL DEFAULT 'cash',
    "details" JSON                              DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS payment_details_seq;
CREATE TABLE IF NOT EXISTS "payment_details"
(
    "id"        BIGINT PRIMARY KEY       NOT NULL DEFAULT (nextval('payment_details_seq')),
    "method_id" BIGINT                   NOT NULL,
    "status"    AVAILABLE_PAYMENT_STATUS NOT NULL DEFAULT 'not successful'
);

CREATE SEQUENCE IF NOT EXISTS address_seq;
CREATE TABLE IF NOT EXISTS "address"
(
    "id"      BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('address_seq')),
    "country" VARCHAR                     DEFAULT 'Российская Федерация',
    "region"  VARCHAR,
    "city"    VARCHAR,
    "street"  VARCHAR,
    "house"   VARCHAR(20),
    "flat"    VARCHAR(10),
    "other"   VARCHAR
);

CREATE SEQUENCE IF NOT EXISTS delivery_details_seq;
CREATE TABLE IF NOT EXISTS "delivery_details"
(
    "id"            BIGINT PRIMARY KEY        NOT NULL DEFAULT (nextval('delivery_details_seq')),
    "address_id"    BIGINT                    NOT NULL,
    "delivery_dttm" TIMESTAMP,
    "notes"         VARCHAR,
    "method"        AVAILABLE_DELIVERY_METHOD NOT NULL DEFAULT 'pickup',
    "status"        AVAILABLE_DELIVERY_STATUS NOT NULL DEFAULT 'received'
);

CREATE SEQUENCE IF NOT EXISTS product_category_seq;
CREATE TABLE IF NOT EXISTS "product_category"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_category_seq')),
    "title"     VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL
);
/*
 ToDo
 */
CREATE SEQUENCE IF NOT EXISTS product_special_condition_seq;
CREATE TABLE IF NOT EXISTS "product_special_condition"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_special_condition_seq')),
    "description" TEXT                        DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_photo_seq;
CREATE TABLE IF NOT EXISTS "product_photo"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_photo_seq')),
    "url"       VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_video_seq;
CREATE TABLE IF NOT EXISTS "product_video"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_video_seq')),
    "url"       VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_feedback_seq;
CREATE TABLE IF NOT EXISTS "product_feedback"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_feedback_seq')),
    "grade"       INTEGER            NOT NULL DEFAULT 5,
    "description" TEXT,
    "create_dttm" TIMESTAMP,
    "client_id"   BIGINT,
    "parent_id"   BIGINT                      DEFAULT NULL

);

/*
 ToDo: Add relative_product
 */
CREATE SEQUENCE IF NOT EXISTS product_seq;
CREATE TABLE IF NOT EXISTS "product"
(
    "id"                   BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_seq')),
    "title"                VARCHAR,
    "description"          TEXT,
    "price"                INTEGER,
    "amount"               INTEGER                     DEFAULT 0,
    "photo_id"             BIGINT                      DEFAULT NULL,
    "video_id"             BIGINT                      DEFAULT NULL,
    "option"               JSON                        DEFAULT NULL,
    "category_id"          BIGINT                      DEFAULT NULL,
    "feedback_id"          BIGINT                      DEFAULT NULL,
    "special_condition_id" BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS order_product_seq;
CREATE TABLE "order_product"
(
    "id"         BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('order_product_seq')),
    "product_id" BIGINT             NOT NULL,
    "amount"     INTEGER            NOT NULL DEFAULT 1,
    "price"      INTEGER                     DEFAULT NULL,
    "parent_id"  BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS order_details_seq;
CREATE TABLE "order_details"
(
    "id"                   BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('order_details_seq')),
    "delivery_details_id"  BIGINT             NOT NULL,
    "payment_details_id"   BIGINT             NOT NULL,
    "order_product_id"     BIGINT             NOT NULL,
    "client_id"            BIGINT             NOT NULL,
    "create_dttm"          timestamp,
    "special_condition_id" BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS client_ordered_product_seq;
CREATE TABLE "client_ordered_product"
(
    "id"               BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_ordered_product_seq')),
    "order_details_id" BIGINT             NOT NULL,
    "parent_id"        BIGINT                      DEFAULT NULL

);

CREATE SEQUENCE IF NOT EXISTS client_shopped_product_seq;
CREATE TABLE "client_shopped_product"
(
    "id"         BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_shopped_product_seq')),
    "product_id" BIGINT             NOT NULL,
    "amount"     INTEGER            NOT NULL DEFAULT 1,
    "parent_id"  BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS client_deferred_product_seq;
CREATE TABLE "client_deferred_product"
(
    "id"         BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_deferred_product_seq')),
    "product_id" BIGINT             NOT NULL,
    "parent_id"  BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS client_address_seq;
CREATE TABLE "client_address"
(
    "id"         BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_address_seq')),
    "address_id" BIGINT             NOT NULL,
    "parent_id"  BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS client_payment_seq;
CREATE TABLE "client_payment"
(
    "id"                BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_payment_seq')),
    "payment_method_id" BIGINT             NOT NULL,
    "parent_id"         BIGINT                      DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS client_seq;
CREATE TABLE "client"
(
    "id"                  BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('client_seq')),
    "first_name"          VARCHAR,
    "second_name"         VARCHAR,
    "patronymic"          VARCHAR,
    "phone_number"        VARCHAR(16),
    "mail"                VARCHAR,
    "saved_address_id"    BIGINT                      DEFAULT NULL,
    "saved_payment_id"    BIGINT                      DEFAULT NULL,
    "ordered_product_id"  BIGINT                      DEFAULT NULL,
    "deferred_product_id" BIGINT                      DEFAULT NULL,
    "shopped_product_id"  BIGINT                      DEFAULT NULL
);

ALTER TABLE "delivery_details"
    ADD FOREIGN KEY ("address_id") REFERENCES "address" ("id");

ALTER TABLE "product_category"
    ADD FOREIGN KEY ("parent_id") REFERENCES "product_category" ("id");

ALTER TABLE "product_photo"
    ADD FOREIGN KEY ("parent_id") REFERENCES "product_photo" ("id");

ALTER TABLE "product_video"
    ADD FOREIGN KEY ("parent_id") REFERENCES "product_video" ("id");

ALTER TABLE "product_feedback"
    ADD FOREIGN KEY ("parent_id") REFERENCES "product_feedback" ("id");

ALTER TABLE "product"
    ADD FOREIGN KEY ("photo_id") REFERENCES "product_photo" ("id");

ALTER TABLE "product"
    ADD FOREIGN KEY ("video_id") REFERENCES "product_video" ("id");

ALTER TABLE "product"
    ADD FOREIGN KEY ("category_id") REFERENCES "product_category" ("id");

ALTER TABLE "product"
    ADD FOREIGN KEY ("feedback_id") REFERENCES "product_feedback" ("id");

ALTER TABLE "product"
    ADD FOREIGN KEY ("special_condition_id") REFERENCES "product_special_condition" ("id");

ALTER TABLE "client_ordered_product"
    ADD FOREIGN KEY ("parent_id") REFERENCES "client_ordered_product" ("id");

ALTER TABLE "client_deferred_product"
    ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "client_deferred_product"
    ADD FOREIGN KEY ("parent_id") REFERENCES "client_deferred_product" ("id");

ALTER TABLE "client_shopped_product"
    ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "client_shopped_product"
    ADD FOREIGN KEY ("parent_id") REFERENCES "client_shopped_product" ("id");

ALTER TABLE "client_payment"
    ADD FOREIGN KEY ("payment_method_id") REFERENCES "payment_method" ("id");

ALTER TABLE "client_payment"
    ADD FOREIGN KEY ("parent_id") REFERENCES "client_payment" ("id");

ALTER TABLE "client"
    ADD FOREIGN KEY ("saved_address_id") REFERENCES "client_address" ("id");

ALTER TABLE "client"
    ADD FOREIGN KEY ("saved_payment_id") REFERENCES "client_payment" ("id");

ALTER TABLE "client"
    ADD FOREIGN KEY ("ordered_product_id") REFERENCES "client_ordered_product" ("id");

ALTER TABLE "client"
    ADD FOREIGN KEY ("deferred_product_id") REFERENCES "client_deferred_product" ("id");

ALTER TABLE "client"
    ADD FOREIGN KEY ("shopped_product_id") REFERENCES "client_shopped_product" ("id");

ALTER TABLE "order_details"
    ADD FOREIGN KEY ("delivery_details_id") REFERENCES "delivery_details" ("id");

ALTER TABLE "order_details"
    ADD FOREIGN KEY ("payment_details_id") REFERENCES "payment_details" ("id");

ALTER TABLE "order_details"
    ADD FOREIGN KEY ("client_id") REFERENCES "client" ("id");

ALTER TABLE "order_details"
    ADD FOREIGN KEY ("special_condition_id") REFERENCES "product_special_condition" ("id");

ALTER TABLE "client_ordered_product"
    ADD FOREIGN KEY ("order_details_id") REFERENCES "order_details" ("id");

ALTER TABLE "client_address"
    ADD FOREIGN KEY ("address_id") REFERENCES "address" ("id");

ALTER TABLE "client_address"
    ADD FOREIGN KEY ("parent_id") REFERENCES "client_address" ("id");

ALTER TABLE "product_feedback"
    ADD FOREIGN KEY ("client_id") REFERENCES "client" ("id");

ALTER TABLE "payment_details"
    ADD FOREIGN KEY ("method_id") REFERENCES "payment_method" ("id");

ALTER TABLE "order_product"
    ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "order_product"
    ADD FOREIGN KEY ("parent_id") REFERENCES "order_product" ("id");

ALTER TABLE "order_details"
    ADD FOREIGN KEY ("order_product_id") REFERENCES "order_product" ("id");