package org.example.exception;

public class InvalidInputParamException extends RuntimeException {
    public InvalidInputParamException(String message) {
        super(message);
    }
}
