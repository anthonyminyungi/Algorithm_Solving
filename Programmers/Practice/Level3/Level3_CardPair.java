package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 다익스트라 + 백트랙킹 + 순열
// https://yjyoon-dev.github.io/kakao/2021/01/29/kakao-paircard/ 설명 참고해서 다시 보기
public class Level3_CardPair {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
        System.out.println(solution(new int[][]{{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}}, 0, 1));
    }

    public static int solution(int[][] board, int r, int c) {
        return perm(board, r, c);
    }

    static boolean isFinished(int[][] board) {
        for (int[] arr : board) {
            for (int n : arr) {
                if (n != 0) return false;
            }
        }
        return true;
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }

    static int getDist(int[][] board, int x1, int y1, int x2, int y2) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, x1, y1));

        int[][] dist = new int[4][4];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[x1][y1] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int curDist = cur.dist;

            if (dist[cur.x][cur.y] < curDist) continue;

            if (cur.x == x2 && cur.y == y2) return curDist;

            for (int i = 0; i < dist.length; i++) {
                int cnt = 0;
                int nx = cur.x, ny = cur.y;

                while (isAvailable(nx + dx[i], ny + dy[i])) {
                    cnt++;

                    nx += dx[i];
                    ny += dy[i];
                    if (board[nx][ny] != 0) break;

                    if (dist[nx][ny] > curDist + cnt) {
                        dist[nx][ny] = curDist + cnt;
                        pq.add(new Point(curDist + cnt, nx, ny));
                    }
                }
                if (dist[nx][ny] > curDist + 1) {
                    dist[nx][ny] = curDist + 1;
                    pq.add(new Point(curDist + 1, nx, ny));
                }
            }
        }
        return 0;
    }

    static int perm(int[][] board, int x, int y) {
        if (isFinished(board)) return 0;

        int res = Integer.MAX_VALUE;

        for (int k = 1; k <= 6; k++) {
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == k)
                        points.add(new Point(i, j));
                }
            }
            if (points.isEmpty()) continue;

            int prior_front = getDist(board, x, y, points.get(0).x, points.get(0).y) + getDist(board, points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y) + 2;
            int prior_back = getDist(board, x, y, points.get(1).x, points.get(1).y) + getDist(board, points.get(1).x, points.get(1).y, points.get(0).x, points.get(0).y) + 2;

            board[points.get(0).x][points.get(0).y] = board[points.get(1).x][points.get(1).y] = 0;

            res = Math.min(res, Math.min(prior_front + perm(board, points.get(1).x, points.get(1).y), prior_back + perm(board, points.get(0).x, points.get(0).y)));

            board[points.get(0).x][points.get(0).y] = board[points.get(1).x][points.get(1).y] = k;
        }

        return res;
    }

    static class Point implements Comparable<Point> {
        int x, y, dist;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int dist, int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p) {
            return this.dist - p.dist;
        }
    }
}
