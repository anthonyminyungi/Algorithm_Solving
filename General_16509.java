package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class General_16509 {
    static int kx;
    static int ky;
    static int[][] board = new int[10][9];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int sx = Integer.parseInt(aa[0]);
        int sy = Integer.parseInt(aa[1]);

        String b = br.readLine();
        String[] bb = b.split(" ");
        kx = Integer.parseInt(bb[0]);
        ky = Integer.parseInt(bb[1]);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 1000;
            }
        }
        board[kx][ky] = 100;
        rec(sx, sy, 0);

        if (board[kx][ky] == 100)
            System.out.println(-1);
        else
            System.out.println(board[kx][ky]);
    }

    static void rec(int row, int col, int con) {
        if (row >= 0 && row < 10 && col >= 0 && col < 9 && board[row][col] > con) {
            board[row][col] = con;

            if (!(row - 1 == kx && col == ky) && !(row - 2 == kx && col + 1 == ky)) {
                rec(row - 3, col + 2, con + 1);
            }
            if (!(row - 1 == kx && col == ky) && !(row - 2 == kx && col - 1 == ky)) {
                rec(row - 3, col - 2, con + 1);
            }
            if (!(row == kx && col + 1 == ky) && !(row - 1 == kx && col + 2 == ky)) {
                rec(row - 2, col + 3, con + 1);
            }
            if (!(row == kx && col - 1 == ky) && !(row - 1 == kx && col - 2 == ky)) {
                rec(row - 2, col - 3, con + 1);
            }
            if (!(row == kx && col + 1 == ky) && !(row + 1 == kx && col + 2 == ky)) {
                rec(row + 2, col + 3, con + 1);
            }
            if (!(row == kx && col - 1 == ky) && !(row + 1 == kx && col - 2 == ky)) {
                rec(row + 2, col - 3, con + 1);
            }
            if (!(row + 1 == kx && col == ky) && !(row + 2 == kx && col + 1 == ky)) {
                rec(row + 3, col + 2, con + 1);
            }
            if (!(row + 1 == kx && col == ky) && !(row + 2 == kx && col - 1 == ky)) {
                rec(row + 3, col - 2, con + 1);
            }

        }
    }
}
