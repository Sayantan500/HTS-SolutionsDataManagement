package com.helpdesk_ticketing_system.solutions_data_management.utilities;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilitiesImpl implements Utilities
{

    private final IdGenerator idGenerator;
    private final RequestBodyValidation requestBodyValidation;

    @Autowired
    public UtilitiesImpl(IdGenerator idGenerator, RequestBodyValidation requestBodyValidation) {
        this.idGenerator = idGenerator;
        this.requestBodyValidation = requestBodyValidation;
    }

    @Override
    public String generateId() {
        return idGenerator.generateId();
    }

    @Override
    public boolean validatePostRequestBody(SolutionDocument solutionDocument) {
        return requestBodyValidation.validatePostRequestBody(solutionDocument);
    }
}
