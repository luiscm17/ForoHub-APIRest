package com.luiscm.forohub.model.dto;

import java.time.LocalDateTime;

import com.luiscm.forohub.model.Reply;

public record ReplyDetailDTO(
    Long replyId,
    String message,
    LocalDateTime createdAt,
    boolean solution,
    boolean active,
    Long userId,
    String userName,
    Long topicId
) {
    public ReplyDetailDTO(Reply reply) {
        this(
            reply.getReplyId(),
            reply.getMessage(),
            reply.getCreatedAt(),
            reply.isSolution(),
            reply.isActive(),
            reply.getUser().getId(),
            reply.getUser().getName(),
            reply.getTopic().getTopicId()
        );
    }
}