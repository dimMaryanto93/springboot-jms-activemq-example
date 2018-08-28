package com.maryanto.dimas.responder.example.controller;


import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SendMessageController {

    private final static Logger console = LoggerFactory.getLogger(SendMessageController.class);

    @Autowired
    private JmsTemplate template;

    @PostMapping("/message/send")
    public ResponseEntity<?> sending(
            @Valid @RequestBody PingRequest message,
            HttpServletRequest request) {
        message.setIpAddress(request.getRemoteAddr());
        try {
            template.convertAndSend("ping-request", message);
            PingResponse receive = (PingResponse) template.receiveAndConvert("ping-response");
            console.info("requestId: {}, response: {}", message.getRequestId(), receive);
            return ok().body(receive);
        } catch (JmsException e) {
            e.printStackTrace();
            PingResponse responseBad = new PingResponse();
            responseBad.setIpAddress(message.getIpAddress());
            responseBad.setRequestId(message.getRequestId());
            responseBad.setStatus("DOWN");
            return ok().body(responseBad);
        }
    }
}
