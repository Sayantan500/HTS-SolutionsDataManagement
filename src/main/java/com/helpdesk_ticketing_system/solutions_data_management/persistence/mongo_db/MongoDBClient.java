package com.helpdesk_ticketing_system.solutions_data_management.persistence.mongo_db;

import com.helpdesk_ticketing_system.solutions_data_management.utilities.LoggingUtils;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mongo_client")
class MongoDBClient
{
    private MongoClient mongoClient;

    @Autowired
    MongoDBClient(
            @Qualifier("mongo_username") String USERNAME,
            @Qualifier("mongo_password") String PASSWORD,
            @Qualifier("mongo_connection_baseUri") String BASE_URI
    ) {
        String connectionURI = String.format(BASE_URI, USERNAME, PASSWORD);
        ConnectionString connectionString = new ConnectionString(connectionURI);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        try {
            mongoClient = MongoClients.create(settings);
        } catch (Exception e) {
            LoggingUtils.logError(this.getClass(),e.getMessage());
        }
    }

    public MongoClient getMongoClient(){
        return this.mongoClient;
    }
}
