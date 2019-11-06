package com.ujiuye.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter implements Converter<String, Date> {
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Common中Converter将String转化为Date异常!!!");
            return null;
        }
    }
}
