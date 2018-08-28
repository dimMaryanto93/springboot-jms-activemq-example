package com.maryanto.dimas.responder.example.message;

import com.maryanto.dimas.responder.example.entity.MessageRequest;
import com.maryanto.dimas.responder.example.entity.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserListener {

    private final static Logger console = LoggerFactory.getLogger(UserListener.class);

    @JmsListener(containerFactory = "messageFactory", destination = "/user/by/id")
    public Message<MessageResponse> userRequestById(MessageRequest message) {
        console.info("model request {}", message);

        return MessageBuilder.withPayload(
                new MessageResponse(
                        message.getRequestId(),
                        message.getId(),
                        "dimas",
                        UUID.randomUUID().toString())
        ).build();
    }
}
