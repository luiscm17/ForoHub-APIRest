package com.luiscm.forohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.luiscm.forohub.model.dto.CourseListDTO;
import com.luiscm.forohub.model.dto.CourseRegisterDTO;
import com.luiscm.forohub.model.dto.CourseUpdateDTO;
import com.luiscm.forohub.model.Course;
import com.luiscm.forohub.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<CourseListDTO> create(
            @RequestBody @Valid CourseRegisterDTO courseData,
            UriComponentsBuilder uriBuilder) {
        
        // Crear y guardar el curso
        Course course = new Course(courseData);
        course = courseRepository.save(course);
        
        // Construir la respuesta
        var uri = uriBuilder.path("/courses/{courseId}").buildAndExpand(course.getCourseId()).toUri();
        return ResponseEntity.created(uri).body(new CourseListDTO(course));
    }

    @GetMapping
    public Page<CourseListDTO> listCourses(@PageableDefault (size = 10, sort = "name")Pageable pageable) {
        return courseRepository.findAllByActiveTrue(pageable).map(CourseListDTO::new);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<CourseListDTO> updateCourse(
            @RequestBody @Valid CourseUpdateDTO updateData) {
        
        return courseRepository.findById(updateData.courseId())
            .map(course -> {
                course.updateData(updateData);
                return ResponseEntity.ok(new CourseListDTO(course));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
        return courseRepository.findById(courseId)
            .map(course -> {
                try {
                    course.deactivate();
                    return ResponseEntity.noContent().build();
                } catch (IllegalStateException e) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(e.getMessage());
                }
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
