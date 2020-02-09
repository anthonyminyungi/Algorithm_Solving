package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindNumber_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new LinkedHashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        String[] C = new String[M];
        System.arraycopy(B, 0, C, 0, M);
        Arrays.sort(C);

        for (int i = 0; i < M; i++) {
            int found = Arrays.binarySearch(A, C[i]);
            map.put(C[i], found >= 0 ? 1 : 0);
        }
        for (int i = 0; i < M; i++) {
            bw.append(String.valueOf(map.get(B[i]))).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
