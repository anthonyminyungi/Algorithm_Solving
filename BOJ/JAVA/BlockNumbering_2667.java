package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class BlockNumbering_2667 {
    static int[][] apart;
    static boolean[][] visited;
    static List<Integer> counts;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        apart = new int[N][N];
        visited = new boolean[N][N];
        counts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] in = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                apart[i][j] = in[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && apart[i][j] == 1) {
                    bfs(i, j);
                    counts.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(counts);

        System.out.println(counts.size());
        for (int c : counts) {
            System.out.println(c);
        }
    }

    public static void bfs(int row, int col) {
        visited[row][col] = true;
        count++;
        if (row - 1 >= 0 && !visited[row - 1][col] && apart[row - 1][col] == 1) {
            bfs(row - 1, col);
        }

        if (row + 1 < apart.length && !visited[row + 1][col] && apart[row + 1][col] == 1) {
            bfs(row + 1, col);
        }

        if (col - 1 >= 0 && !visited[row][col - 1] && apart[row][col - 1] == 1) {
            bfs(row, col - 1);
        }

        if (col + 1 < apart.length && !visited[row][col + 1] && apart[row][col + 1] == 1) {
            bfs(row, col + 1);
        }
    }
}
