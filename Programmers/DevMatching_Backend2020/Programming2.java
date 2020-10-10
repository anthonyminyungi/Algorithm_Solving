package com.algorithms.Programmers.DevMatching_Backend2020;

import java.text.*;
import java.util.*;

// 100.0
public class Programming2 {
    public static void main(String[] args) throws ParseException {
        System.out.println(solution("PM 01:00:00", 10));
        System.out.println(solution("PM 11:59:59", 1));
    }

    public static String solution(String p, int n) throws ParseException {
        String answer = null;
        DateFormat readFormat = new SimpleDateFormat("aa hh:mm:ss");
        DateFormat writeFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        Date date = null;
        date = readFormat.parse(p);
        if (date != null) {
            cal.setTime(date);
            cal.add(Calendar.SECOND, n);
        }

        answer = writeFormat.format(cal.getTime());

        return answer;
    }
}

