package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.Profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.Valid;

public record UserRegisterDTO(

    @NotBlank String name,
    
    @NotBlank @Email String email,

    @NotBlank String telephone,
    
    @NotBlank @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$") String password,
    
    @NotNull @Valid Profile profile
) {
    
}
