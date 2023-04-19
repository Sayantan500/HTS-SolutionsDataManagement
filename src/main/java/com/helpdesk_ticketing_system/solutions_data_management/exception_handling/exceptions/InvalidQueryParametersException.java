package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.exceptions;

public class InvalidQueryParametersException extends RuntimeException{
    private final Integer statusCode;

    public InvalidQueryParametersException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
