package com.java.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FashionKing_9375 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Map<String, Integer> map = new LinkedHashMap<>();
            List<String> list = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String cloth = br.readLine().split(" ")[1];
                if (map.containsKey(cloth)) {
                    map.replace(cloth, map.get(cloth) + 1);
                } else {
                    map.put(cloth, 1);
                    list.add(cloth);
                }
            }
            int cases = 1;
            for (int i = 0; i < list.size(); i++) {
                cases *= (map.get(list.get(i)) + 1);
            }
            bw.append(String.valueOf(cases - 1)).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
