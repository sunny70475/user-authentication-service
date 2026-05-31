package com.example.userauthenticationservice.exceptions;

public class UserNotSignedUpException extends RuntimeException{
    public UserNotSignedUpException(String message) {
        super(message);
    }
}
