package com.maryanto.dimas.messages.services;

import com.maryanto.dimas.messages.models.PingRequest;
import com.maryanto.dimas.messages.models.PingResponse;

public interface PingService {

    PingResponse responsePingServer(PingRequest request);
}
