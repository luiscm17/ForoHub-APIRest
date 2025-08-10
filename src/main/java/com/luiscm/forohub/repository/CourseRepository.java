package com.luiscm.forohub.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiscm.forohub.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllByActiveTrue(Pageable pageable);

    boolean existsByCourseIdAndActiveTrue(Long courseId);

    Optional<Course> findByCourseIdAndActiveTrue(Long courseId);

}
