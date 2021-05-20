package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Wormhole_1865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n, m, w;

        int[][] graph;
        final int INF = 987654321;

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph = new int[n][n];

            for (int i = 0; i < n; i++) Arrays.fill(graph[i], INF);

            int s, e, t;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken()) - 1;
                e = Integer.parseInt(st.nextToken()) - 1;
                t = Integer.parseInt(st.nextToken());
                graph[s][e] = graph[e][s] = Math.min(t, graph[s][e]);
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken()) - 1;
                e = Integer.parseInt(st.nextToken()) - 1;
                t = -Integer.parseInt(st.nextToken());
                graph[s][e] = Math.min(t, graph[s][e]);
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (graph[i][j] > graph[i][k] + graph[k][j]) {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }

            boolean isMinus = false;
            for (int i = 0; i < n; i++) {
                if (graph[i][i] < 0) {
                    isMinus = true;
                    break;
                }
            }
            bw.append(isMinus ? "YES" : "NO").append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
