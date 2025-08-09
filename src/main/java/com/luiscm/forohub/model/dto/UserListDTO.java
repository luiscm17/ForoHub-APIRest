package com.luiscm.forohub.model.dto;

import com.luiscm.forohub.model.Profile;
import com.luiscm.forohub.model.User;

public record UserListDTO(
    Long id,
    String name,
    String email,
    String telephone,
    Profile profile
) {

    public UserListDTO(User user) {
        this(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getTelephone(),
            user.getProfile()
        );
    }
}
