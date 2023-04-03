package com.example.microservice2.controllers;

import com.example.microservice2.services.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public ResponseEntity getMessages() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return new ResponseEntity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(messageService.getMessages()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
