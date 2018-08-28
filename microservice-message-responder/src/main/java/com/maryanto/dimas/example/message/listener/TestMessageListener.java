package com.maryanto.dimas.example.message.listener;

import com.maryanto.dimas.example.message.model.TestMessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import java.util.Map;

@Component
public class TestMessageListener {

    private final static Logger console = LoggerFactory.getLogger(UserMessageListener.class);

    @JmsListener(containerFactory = "messageFactory", destination = "/queue/message/test")
    public void userRequestById(
            Session session,
            @Payload Message<TestMessageRequest> message,
            @Headers Map<String, Object> headers) {
        console.info("model request {}", message);
    }
}
