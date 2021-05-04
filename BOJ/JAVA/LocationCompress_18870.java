package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class LocationCompress_18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int a : sorted) {
            if (!map.containsKey(a)) map.put(a, idx++);
        }

        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(map.get(arr[i]))).append(" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
