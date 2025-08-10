package com.luiscm.forohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiscm.forohub.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
