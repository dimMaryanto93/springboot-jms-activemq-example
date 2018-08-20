package com.maryanto.dimas.messages.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PingRequest implements Serializable {

    @NotNull
    private String requestId;
    private String ipAddress;

}
