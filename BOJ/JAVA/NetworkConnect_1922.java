package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Prim Algorithm, Minimum Spanning Tree
public class NetworkConnect_1922 {
    private static int V, E;
    private static LinkedList<Edge>[] graph;
    private static ArrayList<Edge> Mst;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        graph = new LinkedList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new LinkedList<>();
        }
        Mst = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            String[] t = br.readLine().split(" ");
            int s = Integer.parseInt(t[0]);
            int d = Integer.parseInt(t[1]);
            int w = Integer.parseInt(t[2]);
            graph[s].add(new Edge(s, d, w));
            graph[d].add(new Edge(d, s, w));
        }


        MinimumSpanningTree();
        int sum = 0;
        for (int i = 0; i < Mst.size(); i++) {
            sum += Mst.get(i).weight;
        }
        System.out.println(sum);
    }

    private static void MinimumSpanningTree() {
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (Edge edge : graph[now]) {
                if (!visited[edge.dst]) {
                    Q.add(edge);
                }
            }

            while (!Q.isEmpty()) {
                Edge edge = Q.poll();
                if (!visited[edge.dst]) {
                    queue.add(edge.dst);
                    visited[edge.dst] = true;
                    Mst.add(edge);
                    break;
                }
            }
        }
    }


    static class Edge implements Comparable<Edge> {
        int src, dst, weight;

        public Edge(int src, int dst, int weight) {
            super();
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}

