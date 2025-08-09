package com.luiscm.forohub.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
    @NotNull Long id,
    String name,
    @Email String email,
    String password,
    String telephone
    ) {

}
