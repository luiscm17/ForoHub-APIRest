package com.luiscm.forohub.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseUpdateDTO(
    @NotNull Long courseId,
    @NotBlank String name,
    @NotBlank String category
) {

}
