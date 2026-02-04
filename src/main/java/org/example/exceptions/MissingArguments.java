package org.example.exceptions;

public class MissingArguments extends RuntimeException {

    public MissingArguments(String message) {
        super(message);
    }
}
