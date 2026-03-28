CREATE TABLE user (
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    username    VARCHAR(255)    NOT NULL UNIQUE,
    email       VARCHAR(255)    NOT NULL UNIQUE,
    password    VARCHAR(255)    NOT NULL,
    active      BOOLEAN         NOT NULL,
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    last_seen   TIMESTAMP,
    created_at  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);