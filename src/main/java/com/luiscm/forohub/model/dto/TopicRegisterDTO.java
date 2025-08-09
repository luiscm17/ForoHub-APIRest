package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.StatusTopic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegisterDTO (
    @NotBlank String title,
    @NotBlank String message,
    @NotNull Long userId,
    @NotBlank String course,
    @NotBlank StatusTopic status
) {

}
