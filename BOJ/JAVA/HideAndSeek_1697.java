package com.java.BOJ.JAVA;


import java.io.*;
import java.util.LinkedList;

public class HideAndSeek_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);

        BFS(N, K);
        br.close();
        bw.close();
    }

    static void BFS(int N, int K) {
        boolean[] visited = new boolean[100001];
        LinkedList<int[]> queue = new LinkedList<int[]>();

        int[] kv = new int[2];
        int cnt = 0;
        visited[N] = true;
        kv[0] = N;
        kv[1] = cnt;
        queue.add(kv);
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            if (e[0] == K) {
                System.out.println(e[1]);
                break;
            } else {
                if (e[0] > 0) {
                    if (!visited[e[0] - 1]) {
                        int[] tmp = new int[2];
                        tmp[0] = e[0] - 1;
                        tmp[1] = e[1] + 1;
                        queue.add(tmp);
                        visited[tmp[0]] = true;
                    }
                }
                if (e[0] < 100000) {
                    if (!visited[e[0] + 1]) {
                        int[] tmp = new int[2];
                        tmp[0] = e[0] + 1;
                        tmp[1] = e[1] + 1;
                        queue.add(tmp);
                        visited[tmp[0]] = true;
                    }
                }
                if (e[0] <= 50000) {
                    if (!visited[2 * e[0]]) {
                        int[] tmp = new int[2];
                        tmp[0] = e[0] * 2;
                        tmp[1] = e[1] + 1;
                        queue.add(tmp);
                        visited[tmp[0]] = true;
                    }
                }
            }
        }
    }
}
