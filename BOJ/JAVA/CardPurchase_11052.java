package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 점화식을 유추해내기가 꽤 까다로웠던 문제.
public class CardPurchase_11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = card[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
