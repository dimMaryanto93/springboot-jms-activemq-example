package com.maryanto.dimas.messages.models;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PingRequest implements Serializable {

    @NotNull
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
