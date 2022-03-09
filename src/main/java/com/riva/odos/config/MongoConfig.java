package com.riva.odos.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
 
    @Override
    protected String getDatabaseName() {
        return "2020";
    }
 
    @Override
    public MongoClient mongoClient() {
//    	MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("root", getDatabaseName(), "XK4ze7Ao1J".toCharArray());

        ConnectionString connectionString = new ConnectionString("mongodb://{user}:{password}@mongo.dev.odos-tc.demoriva.com:27017/2020?authSource=admin");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
//            .credential(mongoCredential)
            .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 
    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.riva.odos");
    }
}