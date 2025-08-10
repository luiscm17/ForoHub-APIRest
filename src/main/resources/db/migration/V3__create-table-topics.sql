CREATE TABLE topics (
    topic_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'NO_RESPONSE' 
        CHECK (status IN ('NO_RESPONSE', 'NOT_SOLVED', 'SOLVED', 'CLOSED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    user_id BIGINT NOT NULL,
    course_id BIGINT,
    PRIMARY KEY (topic_id),
    CONSTRAINT fk_topic_user 
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_topic_course 
        FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE SET NULL
);
