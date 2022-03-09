package com.riva.odos;


import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableMongoRepositories(basePackages = "com.riva.odos")
public class Application {
    
    public static void main(String[] args) {
        start(System.in, args);
    }

    public static void start(InputStream input, String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
