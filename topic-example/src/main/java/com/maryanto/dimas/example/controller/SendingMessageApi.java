package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.messages.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SendingMessageApi {

    @Autowired
    @Qualifier("topicTemplate")
    private JmsTemplate template;

    @PostMapping("/message/send")
    public ResponseEntity<?> sending(@RequestBody MessageData message) {
        template.convertAndSend("mailbox", message);
        return ok().body("berhasil dikrim");
    }
}
