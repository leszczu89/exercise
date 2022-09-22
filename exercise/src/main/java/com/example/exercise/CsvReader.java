package com.example.exercise;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Service
@RequiredArgsConstructor
public class CsvReader {

    private final PriceMapper priceMapper;
    private final PriceUtils priceUtils;

    public void onMessage(String message) throws IOException {
        Reader reader = new StringReader(message);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine())!= null) {
            Price price = priceMapper.mapToPrice(line);
            priceUtils.prepareAndSavePrice(price);
        }
    }
}
