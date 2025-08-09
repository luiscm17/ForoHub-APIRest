package com.luiscm.forohub.model;


import java.time.LocalDateTime;

import com.luiscm.forohub.model.dto.TopicRegisterDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topics")
@EqualsAndHashCode(of = {"id"})
public class Topic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTopic status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "course_id", nullable = false)
    private Course course;
    
    public Topic(TopicRegisterDTO topic) {
        this.id = null;
        this.title = topic.title();
        this.message = topic.message();
        this.createdAt = LocalDateTime.now();
        this.status = topic.status();
    }

}
