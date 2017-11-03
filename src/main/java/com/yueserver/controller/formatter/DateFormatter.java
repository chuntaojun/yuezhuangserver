package com.yueserver.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * spring 日期格式统一
 */
public class DateFormatter implements Formatter<Date> {

    private String dateParttern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String dateParttern) {
        this.dateParttern = dateParttern;
        dateFormat = new SimpleDateFormat(dateParttern);
        dateFormat.setLenient(false);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        try {
            return dateFormat.parse(text);
        } catch (ParseException e) {
            throw new IllegalArgumentException("error");
        }
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }
}
