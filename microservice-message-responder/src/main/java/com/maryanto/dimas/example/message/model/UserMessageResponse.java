package com.maryanto.dimas.example.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessageResponse implements Serializable {

    private String requestId;
    private String id;
    private String username;
    private String password;

}
