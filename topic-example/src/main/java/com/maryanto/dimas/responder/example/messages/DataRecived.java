package com.maryanto.dimas.responder.example.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class DataRecived implements MessageListener {

    private final static Logger console = LoggerFactory.getLogger(DataRecived.class);

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                console.info("{}", ((TextMessage) message).getText());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
