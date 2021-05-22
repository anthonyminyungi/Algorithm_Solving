package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 좀 색다른 dp 문제. 다시 풀어볼 필요가 있을 것 같다.
// 비슷한 로직으로 dfs 로도 풀 수 있다고 함.
// 참고 : https://hidelookit.tistory.com/118
public class LeaveCompany_14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(p));
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n)
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
