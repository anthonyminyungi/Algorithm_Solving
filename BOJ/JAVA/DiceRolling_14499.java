package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class DiceRolling_14499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        int cmdLength = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[] commands = new int[cmdLength];
        int[] dice = new int[6]; // 0: top, 1: north, 2:east, 3:west, 4:south, 6: bottom;
        //   1
        // 3 0 2
        //   4
        //   5
        int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cmdLength; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cmdLength; i++) {
            int cmd = commands[i] - 1;
            int nx = x + delta[cmd][0], ny = y + delta[cmd][1];
            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
            x = nx;
            y = ny;
            int tmp = dice[0];
            switch (cmd) {
                case 0: // east
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = tmp;
                    break;
                case 1: // west
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = tmp;
                    break;
                case 2: // north
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                    break;
                case 3: //south
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = tmp;
                    break;
                default:
                    break;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice[5];
            } else {
                dice[5] = map[x][y];
                map[x][y] = 0;
            }
            bw.append(String.valueOf(dice[0])).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
