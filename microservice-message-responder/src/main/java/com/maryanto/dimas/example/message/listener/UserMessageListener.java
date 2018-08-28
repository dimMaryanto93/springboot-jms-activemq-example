package com.maryanto.dimas.example.message.listener;

import com.maryanto.dimas.example.message.model.UserMessageRequest;
import com.maryanto.dimas.example.message.model.UserMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMessageListener {

    private final static Logger console = LoggerFactory.getLogger(UserMessageListener.class);

    @JmsListener(containerFactory = "messageFactory", destination = "/user/by/id")
    public Message<UserMessageResponse> userRequestById(UserMessageRequest message) {
        console.info("model request {}", message);

        return MessageBuilder.withPayload(
                new UserMessageResponse(
                        message.getRequestId(),
                        message.getId(),
                        "dimas",
                        UUID.randomUUID().toString())
        ).build();
    }
}
