package com.algorithms.Programmers.Kakao2021Intern;

import java.util.*;

// 풀긴 했으나 시간 지나서 제출 못함
public class Programming4 {
    static List<Integer> trap;
    static int[] trapCnt;
    static int e;

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println(solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int[][] adj = new int[n + 1][n + 1];
        trap = new ArrayList<>();
        trapCnt = new int[11];
        for (int t : traps) trap.add(t);
        for (int[] road : roads) {
            adj[road[0]][road[1]] = road[2];
        }
        e = end;

        return bfs(start, n, adj);
    }

    static int bfs(int start, int n, int[][] adj) {
        int res = Integer.MAX_VALUE;
        Queue<Status> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Status s = new Status(start, 0, -1, adj, visited);
        q.add(s);

        while (!q.isEmpty()) {
            Status cur = q.poll();
            int[][] curDir = cur.directions;
            boolean[] curVisit = cur.visited;
            if (cur.location == e) {
                res = Math.min(res, cur.cost);
            }

            if (trap.contains(cur.location)) {
                trapCnt[cur.location]++;
                if (trapCnt[cur.location] % 2 == 0) {
                    curDir = adj.clone();
                } else {
                    int[][] tempDir = new int[n + 1][n + 1];
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (curDir[i][j] != 0) {
                                int temp = curDir[i][j];
                                tempDir[j][i] = temp;
                                tempDir[i][j] = 0;
                            }
                        }
                    }
                    curDir = tempDir.clone();
                }
                if (trap.contains(cur.from) && (trapCnt[cur.from] + 1) % 2 == 0)
                    curVisit[cur.from] = false;
            }

            for (int i = 1; i <= n; i++) {
                if (curDir[cur.location][i] != 0) {
                    if (curVisit[i]) continue;

                    curVisit[i] = true;
                    Status newStatus = new Status(i, cur.cost + curDir[cur.location][i], cur.location, curDir, curVisit);

                    q.add(newStatus);
                }
            }
        }
        return res;
    }

    static class Status {
        public int[][] directions;
        public boolean[] visited;
        int location, cost, from;

        Status(int location, int cost, int from, int[][] dir, boolean[] vis) {
            this.location = location;
            this.cost = cost;
            this.from = from;
            this.directions = dir.clone();
            this.visited = vis.clone();
        }
    }
}
