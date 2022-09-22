package com.example.exercise;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;
    private final CsvReader csvReader;

    @PostMapping
    public void processCsv(@RequestBody String message) throws IOException {
        csvReader.onMessage(message);
    }

    @GetMapping
    public String getPrice(@RequestParam("name") String name){
        return priceService.getPrice(name);
    }
}
