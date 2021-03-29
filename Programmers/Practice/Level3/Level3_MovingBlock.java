package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 굉장히 어렵게 다가움. 다시 보기
public class Level3_MovingBlock {
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    static int[][] Board;
    static int n;
    static Queue<Point[]> q;
    static boolean[][][] visited;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][][] dRot = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
            {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};
    static int[][][] dCor = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
            {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }

    public static int solution(int[][] board) {
        Board = board;
        n = board.length;
        q = new LinkedList<>();
        visited = new boolean[100][100][4];

        q.add(new Point[]{new Point(0, 0, RIGHT, 0), new Point(0, 1, LEFT, 0)});
        visited[0][0][RIGHT] = true;
        visited[0][1][LEFT] = true;
        Point[] cur = new Point[2];
        Point[] newPt = new Point[2];

        while ((cur = q.poll()) != null) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 2; i++) {
                    newPt[i] = new Point(cur[i].row + d[j][0], cur[i].col + d[j][1], cur[i].dir, cur[i].time + 1);
                }
                if (!isValid(newPt)) continue;

                for (int i = 0; i < 2; i++) {
                    if (newPt[i].row == n - 1 && newPt[i].col == n - 1) return newPt[i].time;
                    visited[newPt[i].row][newPt[i].col][newPt[i].dir] = true;
                }
                q.add(new Point[]{newPt[0], newPt[1]});
            }

            for (int ccw = 0; ccw < 2; ccw++) {
                for (int i = 0; i < 2; i++) {
                    int ret = rotate(cur, ccw, i);
                    if (ret != 0) return ret;
                }
            }
        }

        return 5; // while 문 내에서 무조건 값이 반환되도록 작성함.
        // 여기가지 오는 경우는 경로를 찾지 못하는 경우인데, 그런 경우는 문제에서 없다고 했으므로 아무 값이나 리턴.
    }

    static int rotate(Point[] cur, int ccw, int idx) {
        Point[] newPt = new Point[2];
        int a = idx, b = (idx + 1) % 2;

        int dir = cur[a].dir;
        newPt[0] = new Point(cur[a].row, cur[a].col, (cur[a].dir + (ccw == 0 ? 1 : 3)) % 4, cur[a].time + 1);
        newPt[1] = new Point(cur[b].row + dRot[ccw][dir][0], cur[b].col + dRot[ccw][dir][1], (cur[b].dir + (ccw == 0 ? 1 : 3)) % 4, cur[b].time + 1);

        if (!isValid(newPt)) return 0;
        if (Board[cur[a].row + dCor[ccw][dir][0]][cur[a].col + dCor[ccw][dir][1]] == 1) return 0;

        for (int i = 0; i < 2; i++) {
            if (newPt[i].row == n - 1 && newPt[i].col == n - 1) return newPt[i].time;
            visited[newPt[i].row][newPt[i].col][newPt[i].dir] = true;
        }
        q.add(new Point[]{newPt[0], newPt[1]});
        return 0;
    }

    static boolean isValid(Point[] pt) {
        for (int i = 0; i < 2; i++) {
            if (pt[i].row < 0 || pt[i].row > n - 1 || pt[i].col < 0 || pt[i].col > n - 1) return false;
            if (Board[pt[i].row][pt[i].col] == 1) return false;
            if (visited[pt[i].row][pt[i].col][pt[i].dir]) return false;
        }

        return true;
    }

    static class Point {
        int row, col, dir, time;

        Point(int row, int col, int dir, int time) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.time = time;
        }
    }
}
