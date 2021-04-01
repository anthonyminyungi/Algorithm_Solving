package com.algorithms.Programmers.Practice.Level2;

import java.util.*;

public class Level2_ShortcutInGameMap {
    static int[][] Map;
    static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        Map = maps;
        visited = new boolean[maps.length][maps[0].length];

        Point start = new Point(0, 0);
        return bfs(start);
    }

    static int bfs(Point start) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int row = Map.length, col = Map[0].length;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx > row - 1 || ny > col - 1) continue;
                if (visited[nx][ny] || Map[nx][ny] == 0) continue;

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                Map[nx][ny] = Map[curr.x][curr.y] + 1;
            }
        }

        return !visited[row - 1][col - 1] ? -1 : Map[row - 1][col - 1];
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
