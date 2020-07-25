package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Unknown_1764 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }
        List<String> list = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            if (map.containsKey(find)) {
                cnt++;
                list.add(find);
            }
        }
        bw.append(String.valueOf(cnt)).append("\n");
        Collections.sort(list);
        for (String s : list) {
            bw.append(s).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
