package com.example.exercise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class PriceUtils {
    private final PriceRepository repository;

    public void prepareAndSavePrice(Price price){
        price.setAsk(price.getAsk() + (0.001 * price.getAsk()));
        price.setBid(price.getBid() - (0.001 * price.getBid()));
        repository.save(price);
    }
}
