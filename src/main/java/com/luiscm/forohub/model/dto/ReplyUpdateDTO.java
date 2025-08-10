package com.luiscm.forohub.model.dto;

import jakarta.validation.constraints.NotNull;

public record ReplyUpdateDTO(
    @NotNull
    Long replyId,
    
    String message,
    
    Boolean solution
) {
    
}