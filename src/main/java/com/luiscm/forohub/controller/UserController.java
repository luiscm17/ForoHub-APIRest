package com.luiscm.forohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.luiscm.forohub.model.dto.UserRegisterDTO;
import com.luiscm.forohub.model.User;
import com.luiscm.forohub.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping
    public UserRegisterDTO createUser(@RequestBody @Valid UserRegisterDTO userData) {
        userRepository.save(new User(userData));
        return userData;
    }
}
