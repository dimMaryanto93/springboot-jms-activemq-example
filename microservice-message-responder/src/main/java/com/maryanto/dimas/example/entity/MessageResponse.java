package com.maryanto.dimas.example.entity;

import java.io.Serializable;

public class MessageResponse implements Serializable {
    public MessageResponse() {
    }

    public MessageResponse(String requestId, String id, String username, String password) {
        this.requestId = requestId;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private String requestId;
    private String id;
    private String username;
    private String password;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
