package com.maryanto.dimas.messages.models;

import java.io.Serializable;

public class PingRequest implements Serializable {

    private String requestId;
    private String ipAddress;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
