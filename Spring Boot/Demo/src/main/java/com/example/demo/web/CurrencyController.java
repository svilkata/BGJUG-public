package com.example.demo.web;

import com.example.demo.model.CurrencyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @GetMapping("/add")
    public CurrencyDTO add(@RequestParam CurrencyDTO currency1, @RequestParam CurrencyDTO currency2) {

        return currency1.add(currency2);
    }
}
