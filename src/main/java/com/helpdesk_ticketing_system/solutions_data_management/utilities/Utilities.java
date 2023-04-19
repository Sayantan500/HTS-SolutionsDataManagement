package com.helpdesk_ticketing_system.solutions_data_management.utilities;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;

import java.util.Map;

public interface Utilities
{
    String generateId();
    boolean validatePostRequestBody(SolutionDocument solutionDocument);
    boolean validateGetRequestQueryParameters(Map<String,String> queryParams);
}
