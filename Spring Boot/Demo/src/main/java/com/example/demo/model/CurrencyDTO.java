package com.example.demo.model;

import java.util.Objects;

public record CurrencyDTO(String code, int amount) {

    public CurrencyDTO add(CurrencyDTO that){
        if (!Objects.equals(this.code, that.code)) {
            throw new IllegalArgumentException("Codes are different");
        }

        return new CurrencyDTO(that.code, this.amount + that.amount);
    }
}
