package com.maryanto.dimas.example.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessageRequest {

    private String requestId;
    private String value;
}
