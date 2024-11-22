package com.hexaware.cricketteam.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
