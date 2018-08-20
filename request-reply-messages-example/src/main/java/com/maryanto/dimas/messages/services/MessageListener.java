package com.maryanto.dimas.messages.services;

import org.springframework.messaging.Message;

/**
 * @param <T1> request
 * @param <T2> response
 */
public interface MessageListener<T1, T2> {

    Message<T2> listen(T1 request);
}
