package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidRequestBodyExceptionResponse
{
    @JsonProperty("status") private final Integer status;
    @JsonProperty("error_param") private final String parameter;
    @JsonProperty("message") private final String message;

    public InvalidRequestBodyExceptionResponse(Integer status, String parameter, String message) {
        this.status = status;
        this.parameter = parameter;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getParameter() {
        return parameter;
    }

    public String getMessage() {
        return message;
    }
}
