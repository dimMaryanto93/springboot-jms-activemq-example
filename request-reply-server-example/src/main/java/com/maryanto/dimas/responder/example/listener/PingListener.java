package com.maryanto.dimas.responder.example.listener;

import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;
import com.maryanto.dimas.messages.services.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PingListener implements MessageListener<PingRequest, PingResponse> {

    @Autowired
    private Environment env;

    private final static Logger console = LoggerFactory.getLogger(PingListener.class);

    @Override
    @JmsListener(destination = "ping-request", containerFactory = "messageFactory")
    @SendTo("ping-response")
    public Message<PingResponse> listen(PingRequest request) {
        console.info("request: {}, port: {}", request, env.getProperty("server.port"));
        PingResponse response = new PingResponse();
        response.setRequestId(request.getRequestId());
        response.setIpAddress(request.getIpAddress());
        response.setStatus("OK");
        return MessageBuilder
                .withPayload(response)
                .setHeader("code", request.getRequestId())
                .build();
    }
}
