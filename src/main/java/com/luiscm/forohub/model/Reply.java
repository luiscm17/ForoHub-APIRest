package com.luiscm.forohub.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "replyId")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private boolean solution = false;
    
    @Column(nullable = false)
    private boolean active = true;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructor para crear una nueva respuesta
    public Reply(String message, Topic topic, User user) {
        this.message = message;
        this.topic = topic;
        this.user = user;
    }

    // Método para marcar como solución
    public void markAsSolution() {
        this.solution = true;
    }

    // Método para desmarcar como solución
    public void unmarkAsSolution() {
        this.solution = false;
    }

    // Método para desactivar (soft delete)
    public void deactivate() {
        this.active = false;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}