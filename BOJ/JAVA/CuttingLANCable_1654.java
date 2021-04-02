package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CuttingLANCable_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int k = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);

        long[] cables = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            cables[i] = Long.parseLong(br.readLine());
            max = Math.max(max, cables[i]);
        }

        long res = 0, start = 1, end = max; // start를 0으로 하면 런타임에러 발생 가능.

        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            for (long cable : cables) {
                cnt += cable / mid;

            }
            if (cnt >= n) { // mid 길이만큼 자른 개수가 n보다 크면 더 작은 길이로 잘렸다는 뜻.
                res = Math.max(res, mid);
                start = mid + 1; // mid 이상의 구간을 시작으로 다시 탐색
            } else {
                end = mid - 1;
            }
        }
        System.out.println(res);
    }
}
