package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_BuildingRoad {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, min;

    public static void main(String[] args) {
        int[][] one = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int[][] two = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        int[][] three = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0}
        };
        int[][] four = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
        System.out.println(solution(one));
        System.out.println(solution(two));
        System.out.println(solution(three));
        System.out.println(solution(four));
    }

    public static int solution(int[][] board) {
        min = Integer.MAX_VALUE;
        n = board.length;
        map = board;

        bfs(0, 0, 0, -1);

        return min;
    }

    static void bfs(int x, int y, int cost, int dir) {
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(x, y, cost, dir));
        map[0][0] = 1;

        while (!q.isEmpty()) {
            Road cur = q.poll();
            if (cur.x == n - 1 && cur.y == n - 1) {
                if (min > cur.cost)
                    min = cur.cost;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1 || map[nx][ny] == 1) continue;


                int nc = 0;
                if (cur.dir == -1 || cur.dir == i) nc = cur.cost + 100;
                else nc = cur.cost + 600;

                if (map[nx][ny] == 0 || map[nx][ny] >= nc) {
                    map[nx][ny] = nc;
                    q.add(new Road(nx, ny, nc, i));
                }
            }
        }
    }

    static class Road {
        int x, y, cost, dir;

        Road(int x, int y, int c, int d) {
            this.x = x;
            this.y = y;
            this.cost = c;
            this.dir = d;
        }
    }
}
