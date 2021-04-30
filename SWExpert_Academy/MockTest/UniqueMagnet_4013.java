package com.algorithms.SWExpert_Academy.MockTest;

import java.io.*;
import java.util.*;

public class UniqueMagnet_4013 {
    static int K;
    static int[][] magnets = new int[4][8];
    static int[] rotatable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int T = t;

        while (t-- > 0) {
            K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                magnets[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int k = 0; k < K; k++) {
                int[] nd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int n = nd[0] - 1, d = nd[1];
                rotatable = new int[4];
                check(n, d);
                for (int i = 0; i < 4; i++) {
                    rotate(i);
                }
            }

            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += ((int) Math.pow(2, i)) * magnets[i][0];
            }

            bw.append("#").append(String.valueOf(T - t)).append(" ").append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void check(int n, int d) {
        if (n < 0 || n > 3) return;
        if (rotatable[n] == 0) rotatable[n] = d;
        else return;

        if (n + 1 < 4 && magnets[n][2] != magnets[n + 1][6]) check(n + 1, -d);
        if (n - 1 >= 0 && magnets[n][6] != magnets[n - 1][2]) check(n - 1, -d);
    }

    static void rotate(int n) {
        int[] tempArr = new int[7];
        if (rotatable[n] > 0) {
            int temp = magnets[n][7];
            System.arraycopy(magnets[n], 0, tempArr, 0, 7);
            System.arraycopy(tempArr, 0, magnets[n], 1, 7);
            magnets[n][0] = temp;
        } else if (rotatable[n] < 0) {
            int temp = magnets[n][0];
            System.arraycopy(magnets[n], 1, tempArr, 0, 7);
            System.arraycopy(tempArr, 0, magnets[n], 0, 7);
            magnets[n][7] = temp;
        }
    }
}

