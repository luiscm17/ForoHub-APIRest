package com.luiscm.forohub.model.dto;

import java.time.LocalDateTime;

import com.luiscm.forohub.model.StatusTopic;
import com.luiscm.forohub.model.Topic;

public record TopicDetailDTO(
    Long topicId,
    String title,
    String message,
    StatusTopic status,
    LocalDateTime createdAt,
    Long userId,
    Long courseId
) {
    public TopicDetailDTO(Topic topic) {
        this(
            topic.getTopicId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getStatus(),
            topic.getCreatedAt(),
            topic.getUser().getId(),
            topic.getCourse() != null ? topic.getCourse().getCourseId() : null
        );
    }
}
