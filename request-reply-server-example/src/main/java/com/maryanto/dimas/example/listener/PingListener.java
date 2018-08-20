package com.maryanto.dimas.example.listener;

import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;
import com.maryanto.dimas.messages.services.PingService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PingListener implements PingService {

    @JmsListener(destination = "ping-request", containerFactory = "messageFactory")
    @SendTo("ping-response")
    public Message<PingResponse> pingListener(PingRequest request) {
        PingResponse response = responsePingServer(request);
        return MessageBuilder
                .withPayload(response)
                .setHeader("code", request.getRequestId())
                .build();
    }

    @Override
    public PingResponse responsePingServer(PingRequest request) {
        PingResponse response = new PingResponse();
        response.setIpAddress(request.getIpAddress());
        response.setRequestId(request.getRequestId());
        response.setStatus("OK");
        return response;
    }
}
