package com.helpdesk_ticketing_system.solutions_data_management.utilities;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;

public interface Utilities
{
    String generateId();
    boolean validatePostRequestBody(SolutionDocument solutionDocument);
}
