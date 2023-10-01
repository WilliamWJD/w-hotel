package com.wjd.hotel.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParse {

    public static LocalDate paraLocalDate(final String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(data, formatter);
    }
}
