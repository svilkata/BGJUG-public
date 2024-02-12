package com.example.demo.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConvertor implements Converter<String, CurrencyDTO> {  //<source, value>

    @Override
    public CurrencyDTO convert(String source) {
        var split = source.split(" ");

        return new CurrencyDTO(split[1], Integer.parseInt(split[0]));
    }
}
