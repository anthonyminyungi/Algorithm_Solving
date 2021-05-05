package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class SnakeLadderGame_16928 {
    static Map<Integer, Integer> ladders;
    static Map<Integer, Integer> snakes;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];


        ladders = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] ladder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ladders.put(ladder[0], ladder[1]);
        }

        snakes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] snake = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            snakes.put(snake[0], snake[1]);
        }

        visited = new boolean[101];
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(1, 0));
        visited[1] = true;

        int min = 987654321;
        while (!q.isEmpty()) {
            Location cur = q.poll();
            if (cur.num == 100) min = Math.min(min, cur.dice);

            if (cur.num < 100) {
                for (int i = 1; i <= 6; i++) {
                    int nl = cur.num + i;
                    if (nl > 100) continue;
                    if (visited[nl]) continue;
                    if (snakes.containsKey(nl)) {
                        visited[nl] = true;
                        nl = snakes.get(nl);
                    } else if (ladders.containsKey(nl)) {
                        visited[nl] = true;
                        nl = ladders.get(nl);
                    }

                    q.add(new Location(nl, cur.dice + 1));
                    visited[nl] = true;
                }
            }
        }

        return min;
    }

    static class Location {
        int num, dice;

        Location(int n, int d) {
            this.num = n;
            this.dice = d;
        }
    }
}
