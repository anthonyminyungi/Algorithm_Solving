package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneNumberList_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new LinkedHashMap<>();
            String[] phone_book = new String[n];
            boolean answer = true;
            for (int i = 0; i < n; i++) {
                phone_book[i] = br.readLine();
                map.put(phone_book[i], i);
            }
            for (String a : phone_book) {
                for (int j = 0; j < a.length(); j++) {
                    String b = a.substring(0, j);
                    if (map.containsKey(b)) {
                        answer = false;
                        break;
                    }
                    if (!answer)
                        break;
                }
            }
            if (!answer)
                bw.append("NO\n");
            else
                bw.append("YES\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
