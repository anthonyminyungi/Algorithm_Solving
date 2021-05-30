package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Cheese_2326 {
    static int[][] grid;
    static boolean[][] isAir;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> cheeseEdge;
    static int row, col;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        grid = new int[row][col];
        isAir = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int meltCnt = 0, time = 0;
        while (true) {
            getAirArea();
            if (cheeseEdge.isEmpty()) {
                break;
            }
            meltCnt = meltCheese();
            time++;
        }

        System.out.println(time + "\n" + meltCnt);
    }

    static void getAirArea() {
        Queue<int[]> q = new LinkedList<>();
        cheeseEdge = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        isAir[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + d[i][0], ny = cur[1] + d[i][1];
                if (nx < 0 || ny < 0 || nx > row - 1 || ny > col - 1) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 1) {
                    cheeseEdge.add(new int[]{nx, ny});
                    continue;
                }

                isAir[nx][ny] = true;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    static int meltCheese() {
        int cnt = 0;
        while (!cheeseEdge.isEmpty()) {
            int[] cur = cheeseEdge.poll();
            if (!isAir[cur[0]][cur[1]]) {
                grid[cur[0]][cur[1]] = 0;
                isAir[cur[0]][cur[1]] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
