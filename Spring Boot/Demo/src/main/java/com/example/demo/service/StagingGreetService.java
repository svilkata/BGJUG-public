package com.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("staging")
public class StagingGreetService implements GreetingService{
    @Override
    public String greet() {
        return "Hello from STAGING";
    }
}
