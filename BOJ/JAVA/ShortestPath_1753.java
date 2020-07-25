package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath_1753 {
    private static int V;
    private static int src;
    private static PriorityQueue<Vtx> Q;
    private static List<List<Vtx>> graph;
    private static int[] d;
    private static int INF = Integer.MAX_VALUE;

    private static void dijkstra() {
        Arrays.fill(d, INF);
        d[src] = 0;
        Q.add(new Vtx(src, 0));
        boolean[] visited = new boolean[V + 1];
        while (!Q.isEmpty()) {
            Vtx Vt = Q.remove();
            int u = Vt.name;
            if (visited[u]) continue;
            visited[u] = true;

            for (Vtx vtx : graph.get(u)) {
                if (d[vtx.name] > d[u] + vtx.dist) {
                    d[vtx.name] = d[u] + vtx.dist;
                    Q.add(new Vtx(vtx.name, d[vtx.name]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        V = Integer.parseInt(in[0]);
        int E = Integer.parseInt(in[1]);

        src = Integer.parseInt(br.readLine());
        Q = new PriorityQueue<Vtx>();
        d = new int[V + 1];
        graph = new ArrayList<List<Vtx>>();
        graph.add(new ArrayList<Vtx>());
        for (int i = 1; i <= V; i++) {
            graph.add(new ArrayList<Vtx>());
        }


        for (int i = 0; i < E; i++) {
            String[] e = br.readLine().split(" ");
            graph.get(Integer.parseInt(e[0])).add(new Vtx(Integer.parseInt(e[1]), Integer.parseInt(e[2])));
        }

        dijkstra();
        for (int i = 1; i < d.length; i++) {
            if (d[i] == INF)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }
}

class Vtx implements Comparable<Vtx> {
    int name;
    int dist;

    Vtx(int n, int d) {
        name = n;
        dist = d;
    }

    @Override
    public int compareTo(Vtx v) {
        // return this.dist - v.dist
        if (this.dist > v.dist)
            return 1;
        else if (this.dist < v.dist)
            return -1;
        else
            return 0;
    }
}

