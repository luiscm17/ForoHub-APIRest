package com.luiscm.forohub.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseRegisterDTO(
    @NotBlank String name,
    @NotBlank String category
) {

}
