package com.luiscm.forohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.luiscm.forohub.model.dto.TopicDetailDTO;
import com.luiscm.forohub.model.dto.TopicRegisterDTO;
import com.luiscm.forohub.model.dto.TopicUpdateDTO;
import com.luiscm.forohub.exception.ResourceNotFoundException;
import com.luiscm.forohub.model.Course;
import com.luiscm.forohub.model.Topic;
import com.luiscm.forohub.model.User;
import com.luiscm.forohub.repository.CourseRepository;
import com.luiscm.forohub.repository.TopicRepository;
import com.luiscm.forohub.repository.UserRepository;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<TopicDetailDTO> create(
            @RequestBody @Valid TopicRegisterDTO data,
            UriComponentsBuilder uriBuilder) {
        
        // Verificar que el usuario existe
        User user = userRepository.findById(data.userId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
            
        // El curso es opcional
        Course course = null;
        if (data.courseId() != null) {
            course = courseRepository.findById(data.courseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        }
        
        // Crear y guardar el tema
        Topic topic = new Topic(data, user, course);
        topic = topicRepository.save(topic);
        
        // Construir la respuesta
        var uri = uriBuilder.path("/topics/{topicId}").buildAndExpand(topic.getTopicId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDetailDTO(topic));
    }

    @GetMapping
    public Page<TopicDetailDTO> ListTopics(@PageableDefault (size = 10, sort = "createdAt")Pageable pageable) {
        return topicRepository.findAll(pageable).map(TopicDetailDTO::new);
    }

    @GetMapping("/{topicId}")
    public TopicDetailDTO getTopic(@PathVariable Long topicId) {
        return topicRepository.findById(topicId)
            .map(TopicDetailDTO::new)
            .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));
    }

    @Transactional
    @PutMapping
    public void updateTopic(@RequestBody @Valid TopicUpdateDTO topicData) {
        var topic = topicRepository.getReferenceById(topicData.topicId());
        topic.updateData(topicData);
    }

    @Transactional
    @DeleteMapping("/{topicId}")
    public void deleteTopic(@PathVariable Long topicId) {
        var topic = topicRepository.getReferenceById(topicId);
        topic.deleteTopic();
    }

}
