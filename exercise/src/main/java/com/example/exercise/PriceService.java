package com.example.exercise;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public String getPrice(String name){
        Price price = priceRepository.findByName(name).orElseThrow();
        return priceMapper.mapToString(price);
    }
}
