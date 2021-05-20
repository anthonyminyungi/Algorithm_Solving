package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Wormhole_1865 {
    static final int INF = 987654321;
    static int n, m, w;
    static List<Edge>[] edges;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges = new ArrayList[n];
            dist = new int[n];

            for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();

            int s, e, t;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken()) - 1;
                e = Integer.parseInt(st.nextToken()) - 1;
                t = Integer.parseInt(st.nextToken());
                edges[s].add(new Edge(e, t));
                edges[e].add(new Edge(s, t));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken()) - 1;
                e = Integer.parseInt(st.nextToken()) - 1;
                t = -Integer.parseInt(st.nextToken());
                edges[s].add(new Edge(e, t));
            }

            boolean isMinus = false;
            for (int i = 0; i < n; i++) {
                if (bellmanFord(i)) {
                    isMinus = true;
                    break;
                }
            }
            // 문제에 출발점이 명시되어있지 않기 때문에 모든 정점에 대해 음수 사이클 확인.

            bw.append(isMinus ? "YES" : "NO").append("\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean isUpdate = false;

        // 벨만포드는 edge relaxation(update) 을 V-1 회만큼 수행함.
        for (int i = 0; i < n - 1; i++) {
            isUpdate = false;
            for (int j = 0; j < n; j++) {
                for (Edge edge : edges[j]) {
                    if (dist[j] != INF && dist[edge.dst] > dist[j] + edge.weight) {
                        // 임의의 출발점에 대해서 음수 사이클 여부만 1회 확인하려고 한다면
                        // dist[j] != INF 조건 불필요
                        dist[edge.dst] = dist[j] + edge.weight;
                        isUpdate = true;
                    }
                }
            }
            if (!isUpdate) break;
        }
        // (V- 1)번까지 계속 업데이트가 발생했을 경우
        // V 번째에도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (isUpdate) {
            for (int i = 0; i < n; i++) {
                for (Edge edge : edges[i]) {
                    if (dist[i] != INF && dist[edge.dst] > dist[i] + edge.weight)
                        return true;
                }
            }
        }

        return false;
    }

    static class Edge {
        int dst, weight;

        Edge(int d, int w) {
            this.dst = d;
            this.weight = w;
        }
    }
}
