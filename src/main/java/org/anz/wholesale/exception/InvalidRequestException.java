package org.anz.wholesale.exception;

/**
 * Created by hariharank12 on 25/11/20.
 */
public class InvalidRequestException extends UnsupportedOperationException {

    public InvalidRequestException(String message) { this(message, null); }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}