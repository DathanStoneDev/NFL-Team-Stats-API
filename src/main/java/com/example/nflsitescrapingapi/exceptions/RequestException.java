package com.example.nflsitescrapingapi.exceptions;

public class RequestException extends RuntimeException{

    public RequestException(String message) {
        super(message);
    }
}
