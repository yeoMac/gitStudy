create table member(
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(100) NOT NULL,
    role varchar(50) NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)