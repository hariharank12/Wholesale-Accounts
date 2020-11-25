package org.anz.wholesale.exception;

/**
 * Created by hariharank12 on 25/11/20.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this("Resource not found");
    }

    public ResourceNotFoundException(String message) {
        this(message, null);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}