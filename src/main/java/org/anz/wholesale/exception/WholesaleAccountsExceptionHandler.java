package org.anz.wholesale.exception;

import org.anz.wholesale.model.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by hariharank12 on 25/11/20.
 */
@RestControllerAdvice
public class WholesaleAccountsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException) {
        GlobalError globalError = new GlobalError(resourceNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(globalError, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException invalidRequestException) {
        GlobalError globalError = new GlobalError(invalidRequestException.getMessage(),
                HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(globalError, HttpStatus.BAD_REQUEST);

    }

}
