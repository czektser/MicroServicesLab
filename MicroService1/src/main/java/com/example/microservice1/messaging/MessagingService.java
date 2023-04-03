package com.example.microservice1.messaging;

import com.example.microservice1.models.HelloWorldMessage;

public interface MessagingService {
    void sendMessage(HelloWorldMessage message) throws Exception;
}
