package com.example.demo.config;

import bg.jug.calculator.service.CalculatorService; //from calculation-service-library
import bg.jug.calculator.service.CalculatorServiceBuilderCustomizer; //from calculation-service-library
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

//    @Bean
//    public CalculatorServiceBuilderCustomizer calculatorServiceBuilderCustomizer() {
//        return b -> {
//            b.setStartMessage("Customized start message: %d and %d");
//            b.setFinishMessage("Customized return message: %d");
//        };
//    }

    @Bean
    public CalculatorService customCalculatorService() {
//        return (op1, op2) -> op1 * op2;
        return new CalculatorService() {
            @Override
            public int apply(int op1, int op2) {
                System.out.printf("Changed from addition to mutiply. Operands are: %d and %d", op1, op2);
                System.out.println();
                return op1 * op2;
            }
        };
    }
}
