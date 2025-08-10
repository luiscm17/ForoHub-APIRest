package com.luiscm.forohub.model.dto;

import java.time.format.DateTimeFormatter;

import com.luiscm.forohub.model.Course;

public record CourseListDTO(
    Long courseId,
    String name,
    String category,
    boolean active,
    String createdAt
    
) {
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public CourseListDTO(Course course) {
        this(
            course.getCourseId(),
            course.getName(),
            course.getCategory(),
            course.isActive(),
            course.getCreatedAt() != null ? course.getCreatedAt().format(formatter) : "No disponible"
        );
    }

}
