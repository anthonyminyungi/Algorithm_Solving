package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 직접 푼 코드로 정답 확인 후
// 다른 수행시간이 빠른 정답 코드 참고해서 분석해봄.
public class StartAndLink_14889 {
    static int answer = 987654321, n;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getScore(0, 0, 0, 0, 0);
        System.out.println(answer / 2);
        // answer 를 구할 때 양쪽의 합에 여전히 최종 선택된 경우가 중복되어 계산되어 있으므로
        // 차를 구했지만 그 값에서 2를 나눠줘야함.
    }

    static void getScore(int length, int startLength, int linkLength, int startSum, int linkSum) {
        if (length == n) {
            // 팀 분배가 끝나면 startSum - linkSum 을 수행하는데
            // 여기서 양팀에 중복되어 더해진 경우는 모드 소거됨.
            // 그 차를 구해서 최소의 경우 값 저장
            int ans = startSum - linkSum;
            if (ans < 0) ans = -ans;
            if (answer > ans) answer = ans;
            return;
        }

        int sum = 0;
        // 한 선수(length 번째)를 선택할 때 모든 짝의 경우의 수에 대한 총합
        for (int i = 0; i < n; i++) {
            sum += (grid[length][i] + grid[i][length]);
        }

        if (startLength < n / 2) // length 번째 선수가 start 팀으로 들어갈 경우
            getScore(length + 1, startLength + 1, linkLength, startSum + sum, linkSum);
        if (linkLength < n / 2) // length 번째 선수가 link 팀으로 들어갈 경우
            getScore(length + 1, startLength, linkLength + 1, startSum, linkSum + sum);
    }
}
