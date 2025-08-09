package com.luiscm.forohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiscm.forohub.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
