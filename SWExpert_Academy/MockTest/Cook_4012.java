package com.algorithms.SWExpert_Academy.MockTest;

import java.io.*;
import java.util.*;

public class Cook_4012 {
    static final int INF = 987654321;
    static int N;
    static int[][] tastes = new int[16][16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int T = t;

        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < N; j++) {
                    tastes[i][j] = arr[j];
                }
            }

            bw.append("#").append(String.valueOf(T - t)).append(" ").append(String.valueOf(solve())).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    static List<Integer> getPos(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if ((n & 1) == 1) ret.add(i);
            n = n >> 1;
        }
        return ret;
    }

    static int solve() {
        int ret = INF;

        List<Integer> subsets = new ArrayList<>();
        for (int subset = 0; subset < 1 << N; subset++) {
            if (countBits(subset) == N / 2) {
                subsets.add(subset);
            }
        }

        for (int i = 0; i < subsets.size(); i++) {
            for (int j = i + 1; j < subsets.size(); j++) {
                if ((subsets.get(i) & subsets.get(j)) == 0) {
                    List<Integer> aPos = getPos(subsets.get(i));
                    List<Integer> bPos = getPos(subsets.get(j));
                    int aSum = 0, bSum = 0;
                    for (int k = 0; k < N / 2; k++) {
                        for (int l = 0; l < N / 2; l++) {
                            if (k != l) {
                                aSum += tastes[aPos.get(k)][aPos.get(l)];
                                bSum += tastes[bPos.get(k)][bPos.get(l)];
                            }
                        }
                    }
                    ret = Math.min(ret, Math.abs(aSum - bSum));
                }
            }
        }

        return ret;
    }
}
