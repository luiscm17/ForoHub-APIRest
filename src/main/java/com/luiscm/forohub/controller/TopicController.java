package com.luiscm.forohub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiscm.forohub.model.dto.TopicRegisterDTO;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    @PostMapping
    public void createTopic(@RequestBody TopicRegisterDTO topic) {
        System.out.println(topic);
    }
}
