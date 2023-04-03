package com.example.microservice1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface HelloWorld {
   void publishMessage(String message) throws Exception;
}
