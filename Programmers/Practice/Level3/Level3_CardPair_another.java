package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_CardPair_another {
    static final int INF = 987654321;
    static final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] Board;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
        System.out.println(solution(new int[][]{{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}}, 0, 1));
    }

    public static int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r, c, 0));
    }

    static int permutate(Point src) {
        int ret = INF;

        for (int num = 1; num <= 6; num++) {
            List<Point> cards = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num)
                        cards.add(new Point(i, j, 0));
                }
            }
            if (cards.isEmpty()) continue;

            int one = bfs(src, cards.get(0)) + bfs(cards.get(0), cards.get(1)) + 2;
            int two = bfs(src, cards.get(1)) + bfs(cards.get(1), cards.get(0)) + 2;

            for (int i = 0; i < 2; i++)
                Board[cards.get(i).row][cards.get(i).col] = 0;

            ret = Math.min(ret, one + permutate(cards.get(1)));
            ret = Math.min(ret, two + permutate(cards.get(0)));

            for (int i = 0; i < 2; i++)
                Board[cards.get(i).row][cards.get(i).col] = num; // 다음 번호 카드 고를 때를 위해 복원
        }

        if (ret == INF) return 0;

        return ret;
    }

    static int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.row == dst.row && cur.col == dst.col)
                return cur.cnt;

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + D[i][0], nc = cur.col + D[i][1];
                if (nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, cur.cnt + 1));
                }

                for (int j = 0; j < 2; j++) { // ctrl 입력시에 대한 부분
                    if (Board[nr][nc] != 0) break;
                    if (nr + D[i][0] < 0 || nr + D[i][0] > 3 || nc + D[i][1] < 0 || nc + D[i][1] > 3) break;
                    nr += D[i][0];
                    nc += D[i][1];
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, cur.cnt + 1));
                }
            }
        }

        return INF;
    }

    static class Point {
        int row, col, cnt;

        Point(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.cnt = t;
        }
    }
}
