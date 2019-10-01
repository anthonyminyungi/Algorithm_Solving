package com.java;

import java.io.*;
import java.util.Arrays;

public class WhiteArea_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = new int[8][8];
        int ar;
        int result = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                ar = 0;
            } else {
                ar = 1;
            }
            for (int j = 0; j < 8; j++) {
                board[i][j] = ar;
                if (ar == 1) ar = 0;
                else if (ar == 0) ar = 1;

            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        char[][] input = new char[8][8];
        for (int i = 0; i < 8; i++) {
            input[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (input[i][j] == 'F' && board[i][j] == 0)
                    result++;
            }
        }

        bw.append(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
