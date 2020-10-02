package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class SerialNumber_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i)))
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        if (Character.isDigit(o2.charAt(i)))
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                    }
                    if (sum1 == sum2)
                        return o1.compareTo(o2);
                    else
                        return Integer.compare(sum1, sum2);
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String a : list) {
            System.out.println(a);
        }
    }
}
