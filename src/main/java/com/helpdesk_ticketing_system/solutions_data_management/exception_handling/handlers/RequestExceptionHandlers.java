package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.handlers;

import com.helpdesk_ticketing_system.solutions_data_management.exception_handling.exceptions.InvalidRequestBodyExceptions;
import com.helpdesk_ticketing_system.solutions_data_management.exception_handling.responses.InvalidRequestBodyExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandlers {
    @ExceptionHandler
    public ResponseEntity<InvalidRequestBodyExceptionResponse> handleBadRequestExceptions(
            InvalidRequestBodyExceptions invalidRequestBodyExceptions){
        InvalidRequestBodyExceptionResponse response = new InvalidRequestBodyExceptionResponse(
                invalidRequestBodyExceptions.getHttpStatusCode(),
                invalidRequestBodyExceptions.getParameterName(),
                invalidRequestBodyExceptions.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.valueOf(invalidRequestBodyExceptions.getHttpStatusCode()));
    }
}
