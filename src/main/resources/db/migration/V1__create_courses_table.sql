CREATE TABLE IF NOT EXISTS courses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    status VARCHAR(20),
    is_premium BOOLEAN,
    created_at TIMESTAMP,
    deleted_at TIMESTAMP
);