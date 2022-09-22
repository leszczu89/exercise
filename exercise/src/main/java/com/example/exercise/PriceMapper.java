package com.example.exercise;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PriceMapper {

    public Price mapToPrice(String string){
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy HH:mm:ss:SSS");
        String[] split = string.split(",");
        Date date = null;
        try {
            date = format.parse(split[4]);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        return new Price(Integer.valueOf(split[0]),
                split[1],
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                date);
    }

    public String mapToString(Price price){
        return price.getId() + "," +
                price.getName() + "," +
                price.getBid() + "," +
                price.getAsk() + "," +
                price.getTimestamp();
    }
}
