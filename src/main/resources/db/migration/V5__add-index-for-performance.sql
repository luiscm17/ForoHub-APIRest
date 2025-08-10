CREATE INDEX idx_topics_user_id ON topics(user_id);
CREATE INDEX idx_topics_course_id ON topics(course_id);
CREATE INDEX idx_replies_topic_id ON replies(topic_id);