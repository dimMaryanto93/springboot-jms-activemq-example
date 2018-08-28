package com.maryanto.dimas.responder.example.controller;

import com.maryanto.dimas.responder.example.entity.MessageRequest;
import com.maryanto.dimas.responder.example.entity.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SendingMessageApi {

    @Autowired
    private JmsMessagingTemplate template;

    @PostMapping("/request/user/by/1")
    public ResponseEntity<?> id1(@RequestBody MessageRequest message) throws InterruptedException {
        MessageResponse response = template.convertSendAndReceive(
                "/user/by/id",
                message,
                MessageResponse.class);
        Thread.sleep(5000l);
        return ok().body(response);
    }

    @PostMapping("/request/user/by/2")
    public ResponseEntity<?> id2(@RequestBody MessageRequest message) {
        MessageResponse response = template.convertSendAndReceive(
                "/user/by/id",
                message,
                MessageResponse.class);
        return ok().body(response);
    }
}
