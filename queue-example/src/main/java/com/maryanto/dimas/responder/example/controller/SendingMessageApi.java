package com.maryanto.dimas.responder.example.controller;

import com.maryanto.dimas.responder.example.messages.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SendingMessageApi {

    @Autowired
    private JmsTemplate template;

    @PostMapping("/message/send")
    public ResponseEntity<?> sending(@RequestBody MessageData message) {
        template.convertAndSend("mailbox", message);
        return ok().body("berhasil dikrim");
    }
}
