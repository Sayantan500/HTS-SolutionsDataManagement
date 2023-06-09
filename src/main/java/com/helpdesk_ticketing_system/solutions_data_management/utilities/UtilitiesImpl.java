package com.helpdesk_ticketing_system.solutions_data_management.utilities;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UtilitiesImpl implements Utilities
{

    private final IdGenerator idGenerator;
    private final RequestValidation requestValidation;

    @Autowired
    public UtilitiesImpl(IdGenerator idGenerator, RequestValidation requestValidation) {
        this.idGenerator = idGenerator;
        this.requestValidation = requestValidation;
    }

    @Override
    public String generateId() {
        return idGenerator.generateId();
    }

    @Override
    public boolean validatePostRequestBody(SolutionDocument solutionDocument) {
        return requestValidation.validatePostRequestBody(solutionDocument);
    }

    @Override
    public boolean validateGetRequestQueryParameters(Map<String, String> queryParams) {
        return requestValidation.validateGetRequestQueryParameters(queryParams);
    }
}
