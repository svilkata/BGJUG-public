package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConfigPropertiesDemo {
    private final Logger LOGGER = LoggerFactory.getLogger(ConfigPropertiesDemo.class);

    private final ConfigProps configProps;

    public ConfigPropertiesDemo(ConfigProps configProps) {
        this.configProps = configProps;
    }

    @PostConstruct
    void init() {
        LOGGER.info("First name: {}, Last name: {}", configProps.getFirstName(), configProps.getLastName());
    }
}
