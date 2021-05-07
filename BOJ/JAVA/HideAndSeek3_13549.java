package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class HideAndSeek3_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        boolean[] visited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        int res = Integer.MAX_VALUE;

        int[] kv = new int[2];
        visited[N] = true;
        kv[0] = N;
        q.add(kv);
        while (!q.isEmpty()) {
            int[] e = q.poll();
            if (e[0] == K) {
                res = Math.min(res, e[1]);
            } else {
                if (e[0] * 2 <= 100000 && !visited[2 * e[0]]) {
                    q.add(new int[]{e[0] * 2, e[1]});

                }
                if (e[0] - 1 >= 0 && !visited[e[0] - 1]) {
                    q.add(new int[]{e[0] - 1, e[1] + 1});
                    visited[e[0] - 1] = true;
                }
                if (e[0] + 1 <= 100000 && !visited[e[0] + 1]) {
                    q.add(new int[]{e[0] + 1, e[1] + 1});
                    visited[e[0] + 1] = true;
                }
            }
        }
        return res;
    }
}
