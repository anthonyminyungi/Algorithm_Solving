package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class AgeOrderedSort_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            arr[i][0] = in[0];
            arr[i][1] = in[1];
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });
        for (int i = 0; i < N; i++) {
            bw.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
