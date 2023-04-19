package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.exceptions;

public class InvalidRequestBodyExceptions extends RuntimeException{
    private final Integer httpStatusCode;
    private final String parameterName;
    public InvalidRequestBodyExceptions(String message,Integer httpStatusCode, String parameterName) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.parameterName = parameterName;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getParameterName() {
        return parameterName;
    }
}
