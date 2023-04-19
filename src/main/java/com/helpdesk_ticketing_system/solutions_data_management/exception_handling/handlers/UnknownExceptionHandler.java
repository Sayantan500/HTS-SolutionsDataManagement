package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.handlers;

import com.helpdesk_ticketing_system.solutions_data_management.utilities.LoggingUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UnknownExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleGeneralUnknownExceptions(Exception exception){
        LoggingUtils.logError(this.getClass(),exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
