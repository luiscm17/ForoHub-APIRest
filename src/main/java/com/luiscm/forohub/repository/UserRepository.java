package com.luiscm.forohub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiscm.forohub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByEmail(String email);

}
