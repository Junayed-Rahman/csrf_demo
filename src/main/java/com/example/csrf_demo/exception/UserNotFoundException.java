package com.example.csrf_demo.exception;

public class UserNotFoundException extends NullPointerException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
