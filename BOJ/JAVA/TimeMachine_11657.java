package com.algorithms.BOJ.JAVA;

import java.io.*;

// 재채점때문에 수정
// dist 배열이 int일 때, 문제의 조건 상 음수 사이클이 존재할 때
// Underflow 때문에 멈추지 않고 값이 계속 갱신되는 경우가 발생하므로 dist 배열을
// long 타입으로 변경해주었다.
public class TimeMachine_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Vertex = br.readLine().split(" ");

        int V = Integer.parseInt(Vertex[0]);
        int E = Integer.parseInt(Vertex[1]);

        Graph graph = new Graph(V, E);

        for (int i = 0; i < E; i++) {
            String[] tmp = br.readLine().split(" ");
            graph.edge[i].src = Integer.parseInt(tmp[0]);
            graph.edge[i].dest = Integer.parseInt(tmp[1]);
            graph.edge[i].weight = Integer.parseInt(tmp[2]);
        }

        Graph.BellmanFord(graph, 0);
    }

    static class Graph {
        int V, E;
        Edge[] edge;

        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i = 0; i < e; ++i) {
                edge[i] = new Edge();
            }
        }

        public static void BellmanFord(Graph graph, int src) throws IOException {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int V = graph.V, E = graph.E;
            long[] dist = new long[V];
            for (int i = 0; i < V; ++i) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[src] = 0;

            for (int i = 0; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = graph.edge[j].src - 1;
                    int v = graph.edge[j].dest - 1;
                    int weight = graph.edge[j].weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src - 1;
                int v = graph.edge[j].dest - 1;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println(-1);
                    break;
                } else {
                    if (j == E - 1) {
                        for (int k = 1; k < dist.length; k++) {
                            if (dist[k] == Integer.MAX_VALUE)
                                dist[k] = -1;
                            bw.append(String.valueOf(dist[k])).append(' ');
                        }
                    }
                }
            }
            bw.flush();
            bw.close();
        }
    }

    static class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }
}
