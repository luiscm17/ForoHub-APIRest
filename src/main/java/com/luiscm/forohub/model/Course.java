package com.luiscm.forohub.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.luiscm.forohub.model.dto.CourseRegisterDTO;
import com.luiscm.forohub.model.dto.CourseUpdateDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"courseId"})
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> topics = new ArrayList<>();

    public Course(CourseRegisterDTO courseData) {
        this.name = courseData.name();
        this.category = courseData.category();
    }

    public void updateData(@Valid CourseUpdateDTO courseData) {
        if (courseData.name() != null) {
            this.name = courseData.name();
        }
        
        if (courseData.category() != null) {
            this.category = courseData.category();
        }
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
        topic.setCourse(this);
    }
    
    public void removeTopic(Topic topic) {
        topics.remove(topic);
        topic.setCourse(null);
    }

    public void deactivate() {
        if (!this.topics.isEmpty()) {
            throw new IllegalStateException("No se puede desactivar un curso con tópicos asociados");
        }
        this.active = false;
    }
}
