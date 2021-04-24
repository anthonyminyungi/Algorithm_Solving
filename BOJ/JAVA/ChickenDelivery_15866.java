package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ChickenDelivery_15866 {
    static final int INF = 987654321;
    static int N, M;
    static int hCnt, cCnt;
    static int[] hr = new int[100];
    static int[] hc = new int[100];
    static int[] cr = new int[13];
    static int[] cc = new int[13];
    // 데이터를 2차원 배열로 관리하지 않고 집과 치킨집의 좌표만 관리함.
    // 비트를 활용한 부분집합 연산 활용.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (row[j] == 1) {
                    hr[hCnt] = i;
                    hc[hCnt++] = j;
                } else if (row[j] == 2) {
                    cr[cCnt] = i;
                    cc[cCnt++] = j;
                }
            }
        }

        System.out.println(solve());
    }

    static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    static int solve() {
        int ret = INF;

        for (int subset = 0; subset < 1 << cCnt; subset++) {
            if (countBits(subset) == M) {
                int sum = 0;
                for (int i = 0; i < hCnt; i++) {
                    int dist = INF;
                    for (int j = 0; j < cCnt; j++) {
                        if ((subset & 1 << j) != 0) {
                            dist = Math.min(dist, Math.abs(hr[i] - cr[j]) + Math.abs(hc[i] - cc[j]));
                        }
                    }
                    sum += dist;
                }
                ret = Math.min(ret, sum);
            }
        }
        return ret;
    }
}
