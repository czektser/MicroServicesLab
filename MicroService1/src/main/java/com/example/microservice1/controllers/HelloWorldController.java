package com.example.microservice1.controllers;

import com.example.microservice1.messaging.MessagingService;
import com.example.microservice1.models.HelloWorldMessage;
import com.example.microservice1.services.HelloWorld;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    private MessagingService messageService;

    public HelloWorldController(MessagingService messageService){
        this.messageService = messageService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity updateAccount(@RequestBody HelloWorldMessage message) {
        try {
            messageService.sendMessage(message);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
