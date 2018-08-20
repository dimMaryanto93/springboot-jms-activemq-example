package com.maryanto.dimas.example.listener;

import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;
import com.maryanto.dimas.messages.services.MessageListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PingListener implements MessageListener<PingRequest, PingResponse> {

    @Override
    @JmsListener(destination = "ping-request", containerFactory = "messageFactory")
    @SendTo("ping-response")
    public Message<PingResponse> listen(PingRequest request) {
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
