package com.java.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hashing_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 97; i <= 122; i++) {
            map.put((char) i, i - 96);
        }
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(31, i) * map.get(a.charAt(i));
        }
        System.out.println(sum);
    }
}
