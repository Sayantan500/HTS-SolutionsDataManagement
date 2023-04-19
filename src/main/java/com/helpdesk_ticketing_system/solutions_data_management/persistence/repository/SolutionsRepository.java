package com.helpdesk_ticketing_system.solutions_data_management.persistence.repository;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;

public interface SolutionsRepository {
    String save(SolutionDocument solution) throws Exception;
}
