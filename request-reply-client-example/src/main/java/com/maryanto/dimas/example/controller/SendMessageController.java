package com.maryanto.dimas.example.controller;


import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SendMessageController {

    private final static Logger console = LoggerFactory.getLogger(SendMessageController.class);

    @Autowired
    private JmsTemplate template;

    @PostMapping("/message/send")
    public ResponseEntity<?> sending(@RequestBody PingRequest message) {
        String uuid = UUID.randomUUID().toString();
        console.info("requestId: {}", uuid);
        message.setRequestId(uuid);
        template.convertAndSend("ping-request", message);
        PingResponse receive = (PingResponse) template.receiveAndConvert("ping-response");
        return ok().body(receive);
    }
}