CREATE TABLE replies (
    reply_id BIGINT NOT NULL AUTO_INCREMENT,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    solution BOOLEAN NOT NULL DEFAULT FALSE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    topic_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (reply_id),
    CONSTRAINT fk_reply_topic 
        FOREIGN KEY (topic_id) REFERENCES topics(topic_id) ON DELETE CASCADE,
    CONSTRAINT fk_reply_user 
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
