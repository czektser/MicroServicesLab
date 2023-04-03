package com.example.microservice1.models;

import java.io.Serializable;

public class HelloWorldMessage implements Serializable {
    private String message;

    public void setMessage(String message) {
        this.message =  message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + "'" + "}";
    }
}
