package com.helpdesk_ticketing_system.solutions_data_management.utilities;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;
import com.helpdesk_ticketing_system.solutions_data_management.exception_handling.exceptions.InvalidRequestBodyExceptions;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
class RequestValidation
{
    private final Integer MAX_CHARACTER_LIMIT;

    public RequestValidation(@Qualifier("max_character_limit_for_message") Integer maxCharacterLimit) {
        MAX_CHARACTER_LIMIT = maxCharacterLimit;
    }

    public boolean validatePostRequestBody(SolutionDocument solutionDocument){
        String ticketId = solutionDocument.getTicketId();
        if(StringUtils.isBlank(ticketId) || StringUtils.isEmpty(ticketId) || ticketId.contains(" ")) {
            throw new InvalidRequestBodyExceptions(
                    "NULL or invalid value.",
                    HttpStatus.BAD_REQUEST.value(),
                    "ticket_id"
            );
        }

        String issueId = solutionDocument.getIssueId();
        if(StringUtils.isBlank(issueId) || StringUtils.isEmpty(issueId) || issueId.contains(" ")){
            throw new InvalidRequestBodyExceptions(
                    "NULL or invalid value.",
                    HttpStatus.BAD_REQUEST.value(),
                    "issue_id"
            );
        }

        if(solutionDocument.getSolution()==null){
            throw new InvalidRequestBodyExceptions(
                    "NULL value.",
                    HttpStatus.BAD_REQUEST.value(),
                    "solution"
            );
        }

        String message = solutionDocument.getSolution().getMessage();
        if(StringUtils.isBlank(message) || StringUtils.isEmpty(message)) {
            throw new InvalidRequestBodyExceptions(
                    "NULL or empty value.",
                    HttpStatus.BAD_REQUEST.value(),
                    "solution.message"
            );
        }
        else if(message.length()>MAX_CHARACTER_LIMIT){
            throw new InvalidRequestBodyExceptions(
                    "Contains more than " + MAX_CHARACTER_LIMIT + " characters.",
                    HttpStatus.BAD_REQUEST.value(),
                    "solution.message"
            );
        }

        return true;
    }
}
