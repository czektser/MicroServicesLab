package com.example.microservice1.services;

public class HelloWorldImpl implements HelloWorld{
    public void publishMessage(String message) throws Exception {
        System.out.println("message");
    }
}
