package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.StatusTopic;
import com.luiscm.forohub.model.User;

public record TopicRegisterDTO (
    String title,
    String message,
    Long authorId,
    String course,
    User user,
    StatusTopic status
) {

}
