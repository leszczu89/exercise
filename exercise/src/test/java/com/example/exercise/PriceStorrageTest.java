package com.example.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@SpringBootTest
public class PriceStorrageTest {

    @Autowired
    private CsvReader csvReader;
    @Autowired
    private PriceService priceService;

    @Test
    void testFindingCurrency() throws IOException {
        String s = "106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001\n" +
                "107,EUR/JPY,119.60,119.90,01-06-2020 12:01:02:002\n" +
                "108,GBP/USD,1.2500,1.2560,01-06-2020 12:01:02:002\n" +
                "109,GBP/USD,1.2499,1.2561,01-06-2020 12:01:02:100\n" +
                "110,EUR/JPY,119.61,119.91,01-06-2020 12:01:02:110";
        csvReader.onMessage(s);
        String price = priceService.getPrice("EUR/JPY");
        Assertions.assertFalse(price.isEmpty());
        System.out.println(price);
    }
}
