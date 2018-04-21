package com.ssm.exception;

public class NoException extends RuntimeException {
    public NoException(String message){
        super(message);
    }
    public NoException(String message, Throwable cause) {
        super(message, cause);
    }
}
