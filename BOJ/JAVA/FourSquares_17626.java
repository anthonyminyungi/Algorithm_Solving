package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 코드 다시 읽어보기. 동작 과정 명확하게 이해하기
// cc: https://sihyungyou.github.io/acmicpc2019-H/
// https://www.acmicpc.net/problem/1699 문제 풀어보고 해설 보기 https://sihyungyou.github.io/baekjoon-1699/
public class FourSquares_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[(int) Math.sqrt(n)];
        int[] dp = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * (i + 1);
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int value : arr) {
            for (int j = value; j <= n; j++) {
                dp[j] = Math.min(dp[j - value] + 1, dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
