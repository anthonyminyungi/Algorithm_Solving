package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class TreeDiameter_1167 {
    static List<Node>[] lists;
    static int[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);

            for (int j = 1; j < in.length - 1; j += 2) {
                int y = Integer.parseInt(in[j]);
                int w = Integer.parseInt(in[j + 1]);
                lists[x].add(new Node(y, w));
            }
        }
        int start = 1;
        bfs(start);
        for (int i = 2; i <= n; i++) {
            if (dist[start] < dist[i])
                start = i;
        }
        bfs(start);

        Arrays.sort(dist);
        System.out.println(dist[n]);
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        dist = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int value = queue.poll();
            for (Node node : lists[value]) {
                int n = node.n;
                int w = node.w;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    dist[n] = dist[value] + w;
                }
            }
        }
    }

    static class Node {
        int n;
        int w;

        Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
