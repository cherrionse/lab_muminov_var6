package org.example.VarA;

public class CustomFileProcessingException extends Exception {
    public CustomFileProcessingException(String message) {
        super(message);
    }

    public CustomFileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

}
