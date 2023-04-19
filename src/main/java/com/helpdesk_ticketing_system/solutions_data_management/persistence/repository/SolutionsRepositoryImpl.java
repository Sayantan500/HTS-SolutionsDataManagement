package com.helpdesk_ticketing_system.solutions_data_management.persistence.repository;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;
import com.helpdesk_ticketing_system.solutions_data_management.persistence.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
class SolutionsRepositoryImpl implements SolutionsRepository{
    private final Database<SolutionDocument> database;

    @Autowired
    public SolutionsRepositoryImpl(@Qualifier("mongodb") Database<SolutionDocument> database) {
        this.database = database;
    }

    @Override
    public String save(SolutionDocument solution) throws Exception {
        return database.saveToDb(solution).get_id();
    }

    @Override
    public SolutionDocument get(String fieldName, Object fieldValue) {
        return database.getFromDbBy(fieldName,fieldValue, SolutionDocument.class);
    }
}
