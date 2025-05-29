--liquibase formatted sql
--changeset econcepcion:create-initial-schema
--comment Creates initial tables for users and phones, including constraints.

-- Create 'users' table

CREATE TABLE users (
    id           UUID          NOT NULL PRIMARY KEY,
    name         VARCHAR(55)   NOT NULL,
    email        VARCHAR(55)   NOT NULL CONSTRAINT uq_users_email UNIQUE,
    password     VARCHAR(255)  NOT NULL,
    is_active    BOOLEAN       NOT NULL,
    token        VARCHAR(255)  NOT NULL,
    last_login   TIMESTAMP     NOT NULL,
    created      TIMESTAMP     NOT NULL,
    modified     TIMESTAMP     NOT NULL
);

-- Create 'phones' table
CREATE TABLE phones (
    id            UUID          NOT NULL PRIMARY KEY,
    number        VARCHAR(15)   NOT NULL,
    city_code     VARCHAR(15)   NOT NULL,
    country_code  VARCHAR(15)   NOT NULL,
    user_id       UUID          NOT NULL,
    CONSTRAINT fk_phone_user FOREIGN KEY (user_id) REFERENCES users(id)
);

