package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class NumberCard_10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int q : query) {
            bw.append(String.valueOf(Arrays.binarySearch(arr, q) >= 0 ? 1 : 0)).append(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
