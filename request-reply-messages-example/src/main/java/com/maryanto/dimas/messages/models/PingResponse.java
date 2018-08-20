package com.maryanto.dimas.messages.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PingResponse implements Serializable {

    private String requestId;
    private String ipAddress;
    private String status;
}
