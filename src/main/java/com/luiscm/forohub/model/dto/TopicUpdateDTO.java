package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.StatusTopic;

public record TopicUpdateDTO(
    Long topicId,
    String title,
    String message,
    StatusTopic status
) {

}
