package com.maryanto.dimas.responder.example.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private static final Logger console = LoggerFactory.getLogger(MessageListener.class);

    @JmsListener(destination = "mailbox", containerFactory = "messageFactory")
    public void receiveMessage(MessageData data) {
        console.info("message arrive : {}", data);
    }
}
