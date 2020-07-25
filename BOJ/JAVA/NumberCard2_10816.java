package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberCard2_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>(N + 1);
        String[] A = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(A[i]);
            if (map.containsKey(tmp))
                map.replace(tmp, map.get(tmp) + 1);
            else
                map.put(tmp, 1);
        }
        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            bw.append(String.valueOf(map.getOrDefault(Integer.parseInt(B[i]), 0))).append(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
