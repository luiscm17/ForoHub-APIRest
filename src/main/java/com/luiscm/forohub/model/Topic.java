package com.luiscm.forohub.model;


import java.time.LocalDateTime;

import com.luiscm.forohub.model.dto.TopicRegisterDTO;
import com.luiscm.forohub.model.dto.TopicUpdateDTO;

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
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"topicId"})
@Entity
@Table(name = "topics")
public class Topic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;

    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusTopic status = StatusTopic.NO_RESPONSE;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private boolean active = true;
    
    public Topic(TopicRegisterDTO topicData, User user, Course course) {
        this.title = topicData.title();
        this.message = topicData.message();
        this.user = user;
        this.course = course;
    }

    public void updateData(TopicUpdateDTO topicData) {
        if (topicData.title() != null) {
            this.title = topicData.title();
        }
        
        if (topicData.message() != null) {
            this.message = topicData.message();
        }

        if (topicData.status() != null) {
            this.status = topicData.status();
        }
    }

    public void deleteTopic() {
        this.active = false;
    }

}
