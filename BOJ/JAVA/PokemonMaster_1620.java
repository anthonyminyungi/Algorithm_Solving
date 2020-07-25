package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PokemonMaster_1620 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        String[] arr = new String[N];
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i + 1);
        }
        String[] arr2 = new String[N];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        Arrays.sort(arr2);
        for (int i = 1; i <= M; i++) {
            String k = br.readLine();
            if (k.charAt(0) >= 48 && k.charAt(0) <= 57) {
                bw.append(arr[Integer.parseInt(k) - 1]).append("\n");
            } else {
                bw.append(String.valueOf(map.get(k))).append("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
