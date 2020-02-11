package com.java.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hashing_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Long> map = new LinkedHashMap<>();
        for (int i = 97; i <= 122; i++) {
            map.put((char) i, (long) (i - 96));
        }
        long n = Long.parseLong(br.readLine());
        String a = br.readLine();
        long sum = 0;
        long mul = 1;
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            sum %= 1234567891;
            tmp = (map.get(a.charAt(i)) * mul) % 1234567891;
            sum = (sum + tmp) % 1234567891;
            mul = (mul * 31) % 1234567891;
        }
        System.out.println(sum);
    }
}
