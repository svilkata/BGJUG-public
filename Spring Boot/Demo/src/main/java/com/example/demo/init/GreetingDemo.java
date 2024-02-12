package com.example.demo.init;

import com.example.demo.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GreetingDemo implements CommandLineRunner {

    private List<GreetingService> greeters;

    public GreetingDemo(List<GreetingService> greeters) {
        this.greeters = greeters;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------");

        greeters.forEach(gs -> {
            String greet = gs.greet();
            System.out.println(greet);
        });

        System.out.println("------------");
    }
}
