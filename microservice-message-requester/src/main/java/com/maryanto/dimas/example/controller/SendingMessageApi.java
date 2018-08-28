package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.messages.TestMessageRequest;
import com.maryanto.dimas.example.messages.UserMessageRequest;
import com.maryanto.dimas.example.messages.UserMessageResponse;
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

    @PostMapping("/request/message/test")
    public ResponseEntity<?> test(@RequestBody TestMessageRequest message) {
        template.convertAndSend("/queue/message/test", message);
        return ok().body("Message terkirim");
    }

    @PostMapping("/request/user/by/1")
    public ResponseEntity<?> id1(@RequestBody UserMessageRequest message) throws InterruptedException {
        UserMessageResponse response = template.convertSendAndReceive(
                "/user/by/id",
                message,
                UserMessageResponse.class);
        Thread.sleep(5000l);
        return ok().body(response);
    }

    @PostMapping("/request/user/by/2")
    public ResponseEntity<?> id2(@RequestBody UserMessageRequest message) {
        UserMessageResponse response = template.convertSendAndReceive(
                "/user/by/id",
                message,
                UserMessageResponse.class);
        return ok().body(response);
    }
}
