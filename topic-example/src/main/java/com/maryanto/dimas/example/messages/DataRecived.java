package com.maryanto.dimas.example.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class DataRecived implements javax.jms.MessageListener {

    private final static Logger console = LoggerFactory.getLogger(DataRecived.class);


    @Override
    public void onMessage(Message message) {
        console.info("{}", message);
    }
}
