package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class PartialSum5_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n][n];
        long[][] sum = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = arr[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sum[j][i] = sum[j - 1][i] + arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] += sum[i][j - 1];
            }
            System.out.println(Arrays.toString(sum[i]));
        }
        int x1, y1, x2, y2;
        long pSum;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            if (x1 == x2 && y1 == y2) pSum = arr[x1][y1];
            else {
                pSum = sum[x2][y2];
                if (x1 != 0) pSum -= sum[x1 - 1][y2];
                if (y1 != 0) pSum -= sum[x2][y1 - 1];
                if (x1 != 0 && y1 != 0) pSum += sum[x1 - 1][y1 - 1];

            }
            bw.append(String.valueOf(pSum)).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
