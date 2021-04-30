package com.algorithms.SWExpert_Academy.MockTest;

import java.io.*;
import java.util.*;

public class Pool_1952 {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()), T = t;

        while (t-- > 0) {
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] plans = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<Integer> threePos = new ArrayList<>();

            int ans = INF;
            int[][] dp = new int[3][plans.length];
        }
    }
}
