package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 나는 dp에 대한 상상력이 진짜 약한것같다.
// 참고 : https://sihyungyou.github.io/baekjoon-2293/
public class Coin1_2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                if (j - arr[i] >= 0)
                    dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
