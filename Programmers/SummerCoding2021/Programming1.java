package com.algorithms.Programmers.SummerCoding2021;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("012345", "20190620",
                new String[]{"price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"})));
    }

    public static int[] solution(String code, String day, String[] data) {
        int[] answer = {};
        List<Data> list = new ArrayList<>();
        StringTokenizer st;
        for (String d : data) {
            st = new StringTokenizer(d);
            int price = Integer.parseInt(st.nextToken().split("=")[1]);
            String c = st.nextToken().split("=")[1];
            String date = st.nextToken().split("=")[1];
            long time = transform(date);
            if (code.equals(c) && date.substring(0, 8).equals(day))
                list.add(new Data(c, price, time));
        }

        list.sort((Comparator.comparingLong(o -> o.time)));
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = list.get(i).price;
        return answer;
    }

    static long transform(String s) {
        long times = 0;
        String year = "" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3);
        String month = "" + s.charAt(4) + s.charAt(5);
        String day = "" + s.charAt(6) + s.charAt(7);
        String hour = "" + s.charAt(8) + s.charAt(9);
        times = ((long) Integer.parseInt(year) * 12 * 30 * 24) + ((long) Integer.parseInt(month) * 30 * 24) + (Integer.parseInt(day) * 24L) + Integer.parseInt(hour);
        return times;
    }

    static class Data {
        int price;
        long time;
        String code;

        Data(String code, int price, long time) {
            this.code = code;
            this.price = price;
            this.time = time;
        }
    }
}
