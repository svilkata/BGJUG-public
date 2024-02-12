package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDemoValueAnnotation {
    private final Logger LOGGER = LoggerFactory.getLogger(ConfigDemoValueAnnotation.class);

    private final String firstName;
    private final String lastName;

    public ConfigDemoValueAnnotation(@Value("${demo.env.firstName}") String firstName,
                                     @Value("${demo.env.lastName}") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @PostConstruct
    void init() {
        LOGGER.info("First name: {}, Last name: {}", firstName, lastName);
    }
}
