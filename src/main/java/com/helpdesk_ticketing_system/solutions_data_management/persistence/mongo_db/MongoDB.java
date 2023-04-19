package com.helpdesk_ticketing_system.solutions_data_management.persistence.mongo_db;

import com.helpdesk_ticketing_system.solutions_data_management.persistence.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component("mongodb")
public class MongoDB<T> implements Database<T> {
    private final MongoTemplate mongoTemplate;
    private final String collectionName;
    
    @Autowired
    public MongoDB(
            MongoTemplate mongoTemplate,
            @Qualifier("mongo_collection_name") String collectionName
    ) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = collectionName;
    }

    @Override
    public T saveToDb(T newData)
    {
        return mongoTemplate.insert(newData,collectionName);
    }
}
