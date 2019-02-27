package com.devkuma.spring01demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * SomeBean
 */
public class SomeBean implements SampleBeanInterface{

    private Date date;
    private SimpleDateFormat format;

    public SomeBean(){
        date = Calendar.getInstance().getTime();
        format = new SimpleDateFormat("yyyy/MM/dd");
    }

    @Override
    public String getMessage() {
        return format.format(date);
    }

    @Override
    public void setMessage(String message) {
        try {
            date = format.parse(message);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
    }

    @Override
    public String toString() {
        return "SomeBean [date = " + format.format(date) + "]";
    }
}