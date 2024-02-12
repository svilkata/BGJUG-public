package com.example.demo.init;

import bg.jug.calculator.service.CalculatorService; //from calculation-service-library
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CalculatorDemo implements CommandLineRunner {
    private CalculatorService calculatorService;

    // Constructor injection
    public CalculatorDemo(CalculatorService calculatorService){

        this.calculatorService = calculatorService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(calculatorService.apply(3, 4));
    }
}
