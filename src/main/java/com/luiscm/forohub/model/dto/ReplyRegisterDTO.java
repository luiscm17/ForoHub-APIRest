package com.luiscm.forohub.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReplyRegisterDTO(
    @NotBlank
    String message,
    
    @NotNull
    Long topicId,
    
    @NotNull
    Long userId
) {
    
}