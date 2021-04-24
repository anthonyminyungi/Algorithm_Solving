package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class TreeFinancial_16235 {
    static int N, M, K;
    static int[][] A = new int[10][10];
    static int[][] F = new int[10][10];
    static LinkedList<Tree> trees = new LinkedList<>();
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nmk[0];
        M = nmk[1];
        K = nmk[2];

        for (int i = 0; i < N; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                A[i][j] = in[j];
                F[i][j] = 5;
            }
        }

        int x, y, z;
        for (int i = 0; i < M; i++) {
            int[] xyz = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x = xyz[0];
            y = xyz[1];
            z = xyz[2];

            trees.add(new Tree(x - 1, y - 1, z, true));
        }

        System.out.println(solve());
    }

    static int solve() {
        for (int k = 0; k < K; k++) {
            for (Tree t : trees) {
                if (t.age <= F[t.r][t.c]) {
                    F[t.r][t.c] -= t.age;
                    t.age++;
                } else {
                    t.alive = false;
                }
            }

            for (Iterator<Tree> it = trees.iterator(); it.hasNext(); ) {
                Tree t = it.next();
                if (!t.alive) {
                    F[t.r][t.c] += t.age / 2;
                    it.remove();
                }
            }

            LinkedList<Tree> temp = new LinkedList<>();
            for (Tree t : trees) {
                if (t.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int nr = t.r + dr[i], nc = t.c + dc[i];
                        if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;

                        temp.add(new Tree(nr, nc, 1, true));
                    }
                }
            }

            trees.addAll(0, temp);

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    F[i][j] += A[i][j];
        }

        return trees.size();
    }


    static class Tree {
        int r, c, age;
        boolean alive;

        Tree(int r, int c, int age, boolean alive) {
            this.r = r;
            this.c = c;
            this.age = age;
            this.alive = alive;
        }
    }
}
