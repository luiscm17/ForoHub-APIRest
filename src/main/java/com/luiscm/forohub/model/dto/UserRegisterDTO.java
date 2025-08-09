package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.Profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterDTO(

    @NotBlank String name,
    
    @NotBlank @Email String email,
    
    @NotBlank String password,
    
    @NotNull Profile profile
) {
    
}
