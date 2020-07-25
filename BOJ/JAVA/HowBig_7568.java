package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class HowBig_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] size = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            size[i][0] = Integer.parseInt(in[0]);
            size[i][1] = Integer.parseInt(in[1]);
        }
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (size[i][0] < size[j][0] && size[i][1] < size[j][1]) {
                        rank[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            bw.append(String.valueOf(rank[i])).append(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

//5
//        55 185
//        58 183
//        88 186
//        60 175
//        46 155