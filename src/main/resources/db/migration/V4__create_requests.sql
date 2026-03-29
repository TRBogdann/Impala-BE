CREATE TABLE request_type (
    id      VARCHAR(32)     NOT NULL,
    label   VARCHAR(255)    NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE confirm_account_request (
    id          VARCHAR(36)     NOT NULL,
    user_id     BIGINT          NOT NULL,
    created_at  DATETIME        NOT NULL,
 
    PRIMARY KEY (id),
    CONSTRAINT fk_car_user FOREIGN KEY (user_id) REFERENCES `user` (id)
);

INSERT INTO request_type (id, label) VALUES
('CONFIRM_ACCOUNT', 'Confirm your account');
INSERT INTO request_type (id, label) VALUES
('RESET_PASSWORD', 'Reset password');