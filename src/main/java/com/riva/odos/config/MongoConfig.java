package com.riva.odos.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${mongo.config.db.database}")
	private String database;
	@Value("${mongo.config.db.username}")
	private String username;
	@Value("${mongo.config.db.source}")
	private String source;
	@Value("${mongo.config.db.password}")
	private String password;

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public MongoClient mongoClient() {
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(username, source,
				password.toCharArray());
		String connection = String.format("mongodb://mongo.dev.odos-tc.demoriva.com:27017/%s", database);
		ConnectionString connectionString = new ConnectionString(connection);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.credential(mongoCredential).build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	public Collection getMappingBasePackages() {
		return Collections.singleton("com.riva.odos");
	}
}