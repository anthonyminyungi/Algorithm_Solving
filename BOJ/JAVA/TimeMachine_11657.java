package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TimeMachine_11657 {
    private int V, E;
    private Edge[] edge;

    private TimeMachine_11657(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        String[] Vertex = br.readLine().split(" ");
        ArrayList<String> VEW = new ArrayList<>();

        int V = Integer.parseInt(Vertex[0]);
        int E = Integer.parseInt(Vertex[1]);
        for (int i = 0; i < E; i++) {
            VEW.add(br.readLine());
        }

        TimeMachine_11657 graph = new TimeMachine_11657(V, E);

        for (int i = 0; i < E; i++) {
            String[] tmp = VEW.get(i).split(" ");
            graph.edge[i].src = Integer.parseInt(tmp[0]);
            graph.edge[i].dest = Integer.parseInt(tmp[1]);
            graph.edge[i].weight = Integer.parseInt(tmp[2]);
        }

        graph.BellmanFord(graph, 0);


    }

    private void BellmanFord(TimeMachine_11657 graph, int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];
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
                        System.out.println(dist[k]);
                    }
                }
            }
        }

    }

    static class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }
}
