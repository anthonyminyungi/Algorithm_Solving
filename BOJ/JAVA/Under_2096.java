package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Under_2096 {
    static int n;
    static int d[][] = new int[100001][3];
    static int map[][] = new int[100001][3];

    public static void main(String args[]) throws NumberFormatException, IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        d[1][0] = map[1][0];
        d[1][1] = map[1][1];
        d[1][2] = map[1][2];

        for (int i = 2; i <= n; i++) {
            d[i][0] = map[i][0] + Math.max(d[i - 1][0], d[i - 1][1]);
            d[i][1] = map[i][1] + Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][2] = map[i][2] + Math.max(d[i - 1][1], d[i - 1][2]);
        }
        int max = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));

        for (int i = 2; i <= n; i++) {
            d[i][0] = map[i][0] + Math.min(d[i - 1][0], d[i - 1][1]);
            d[i][1] = map[i][1] + Math.min(d[i - 1][0], Math.min(d[i - 1][1], d[i - 1][2]));
            d[i][2] = map[i][2] + Math.min(d[i - 1][1], d[i - 1][2]);
        }
        int min = Math.min(d[n][0], Math.min(d[n][1], d[n][2]));

        System.out.println(max + " " + min);
    }
}
