CREATE TABLE member(
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(55) NOT NULL,
    password VARCHAR(30) NOT NULL,
    nickname VARCHAR(10) NOT NULL
    );

CREATE TABLE board(
    board_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(30) NOT NULL,
    story VARCHAR(2000) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    member_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES member(member_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
    );

CREATE TABLE category(
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    member_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES member(member_id)
);

CREATE TABLE comment (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(100) NOT NULL,
    created_at DATETIME,
    member_id BIGINT,
    board_id BIGINT,
    parent_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES member(member_id),
    FOREIGN KEY (board_id) REFERENCES board(board_id),
    FOREIGN KEY (parent_id) REFERENCES comment(comment_id)
);