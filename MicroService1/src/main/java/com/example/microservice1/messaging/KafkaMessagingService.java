package com.example.microservice1.messaging;

import com.example.microservice1.models.HelloWorldMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagingService implements MessagingService {
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessagingService(
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(HelloWorldMessage message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            kafkaTemplate.send("helloworld.message.topic", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message));
        } catch (Exception e) {
            throw e;
        }
    }

}
