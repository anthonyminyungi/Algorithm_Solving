package com.java.BOJ.JAVA;

import java.io.*;

public class Box_9455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] size = br.readLine().split(" ");

            int m = Integer.parseInt(size[0]);
            int n = Integer.parseInt(size[1]);

            int[][] grid = new int[m][n];
            for (int j = 0; j < m; j++) {
                String[] arr = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    grid[j][k] = Integer.parseInt(arr[k]);
                }
            }
            int movecnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (grid[k][j] == 1) {
                        for (int d = k; d < m; d++) {
                            movecnt += 1;
                            if (grid[d][j] == 1)
                                movecnt -= 1;
                        }
                    }
                }
            }
            bw.append(movecnt + "\n");


        }
        bw.flush();
    }

}
