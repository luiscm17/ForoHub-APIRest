package com.luiscm.forohub.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luiscm.forohub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByActiveTrue(Pageable pageable);

}
