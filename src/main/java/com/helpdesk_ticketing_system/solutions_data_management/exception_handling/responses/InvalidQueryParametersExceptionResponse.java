package com.helpdesk_ticketing_system.solutions_data_management.exception_handling.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class InvalidQueryParametersExceptionResponse {
    @JsonProperty("status")
    private final Integer statusCode;
    @JsonProperty("message")
    private final String message;

    public InvalidQueryParametersExceptionResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer statusCode() {
        return statusCode;
    }

    public String message() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (InvalidQueryParametersExceptionResponse) obj;
        return Objects.equals(this.statusCode, that.statusCode) &&
                Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message);
    }

    @Override
    public String toString() {
        return "InvalidQueryParametersExceptionResponse[" +
                "statusCode=" + statusCode + ", " +
                "message=" + message + ']';
    }

}
