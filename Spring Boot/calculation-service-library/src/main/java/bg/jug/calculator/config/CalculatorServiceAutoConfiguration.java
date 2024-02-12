package bg.jug.calculator.config;

import bg.jug.calculator.service.CalculatorService;
import bg.jug.calculator.service.CalculatorServiceBuilder;
import bg.jug.calculator.service.CalculatorServiceBuilderCustomizer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
public class CalculatorServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean //този бийн ще бъде включен в spring контекста на приложението, което ще ползва тази библиотека
    public CalculatorServiceBuilder calculatorServiceBuilder(List<CalculatorServiceBuilderCustomizer> customizerList) {
        // The default builder
        CalculatorServiceBuilder builder = new CalculatorServiceBuilder()
                .setStartMessage("Starting calculation with %d and %d")
                .setFinishMessage("The result of the calculation is %d");

        customizerList.forEach(c -> c.customize(builder));

        return builder;
    }


    @Bean
    @ConditionalOnMissingBean //този бийн ще бъде включен в spring контекста на приложението, което ще ползва тази библиотека
    public CalculatorService calculatorService(CalculatorServiceBuilder builder) {
        return builder.build();
    }
}
