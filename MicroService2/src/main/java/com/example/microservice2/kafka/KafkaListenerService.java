package com.example.microservice2.kafka;

import com.example.microservice2.services.MessageService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListenerService {
    private MessageService messageService;

   public KafkaListenerService(MessageService messageService){
       this.messageService = messageService;
   }
    @KafkaListener(topics = "helloworld.message.topic", groupId = "foo")
    public void handle(String message) {
       System.out.println(message);
       messageService.createMessage(message);
    }
}
