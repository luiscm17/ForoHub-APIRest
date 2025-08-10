package com.luiscm.forohub.controller;

import com.luiscm.forohub.exception.ResourceNotFoundException;
import com.luiscm.forohub.model.*;
import com.luiscm.forohub.model.dto.*;
import com.luiscm.forohub.repository.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/replies")
public class ReplyController {
    
    @Autowired
    private ReplyRepository replyRepository;
    
    @Autowired
    private TopicRepository topicRepository;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ReplyDetailDTO> createReply(
            @RequestBody @Valid ReplyRegisterDTO replyData,
            UriComponentsBuilder uriBuilder) {
        
        Topic topic = topicRepository.findById(replyData.topicId())
            .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));
            
        User user = userRepository.findById(replyData.userId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Reply reply = new Reply(replyData.message(), topic, user);
        reply = replyRepository.save(reply);
        
        URI uri = uriBuilder.path("/replies/{id}").buildAndExpand(reply.getReplyId()).toUri();
        return ResponseEntity.created(uri).body(new ReplyDetailDTO(reply));
    }

    @GetMapping
    public Page<ReplyDetailDTO> listReplies(
            @RequestParam(required = false) Long topicId,
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        
        if (topicId != null) {
            return replyRepository.findByTopicTopicId(topicId, pageable)
                .map(ReplyDetailDTO::new);
        }
        
        return replyRepository.findAll(pageable)
            .map(ReplyDetailDTO::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplyDetailDTO> getReply(@PathVariable Long id) {
        return replyRepository.findById(id)
            .map(reply -> ResponseEntity.ok(new ReplyDetailDTO(reply)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ReplyDetailDTO> updateReply(
            @RequestBody @Valid ReplyUpdateDTO updateData) {
        
        return replyRepository.findById(updateData.replyId())
            .map(reply -> {
                if (updateData.message() != null) {
                    reply.setMessage(updateData.message());
                }
                
                if (updateData.solution() != null) {
                    if (updateData.solution()) {
                        reply.markAsSolution();
                    } else {
                        reply.unmarkAsSolution();
                    }
                }
                
                return ResponseEntity.ok(new ReplyDetailDTO(reply));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        return replyRepository.findById(id)
            .map(reply -> {
                reply.deactivate();
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}