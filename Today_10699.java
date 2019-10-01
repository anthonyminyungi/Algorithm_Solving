package com.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Today_10699 {
    public static void main(String[] args) {
        final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(f.format(new Date()));
    }
}