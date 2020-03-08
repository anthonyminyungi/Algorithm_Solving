package com.java.SWExpert_Academy.D2;

import java.io.*;
import java.util.Arrays;

public class SnailNumber_1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int content = 0;
            int x = 0, y = -1;
            String direction = "right";
            for (int j = 0; j < N * N; j++) {
                content++;
                if (direction.equals("right")) {
                    if (y + 1 < N && arr[x][y + 1] == 0) {
                        ++y;
                    } else {
                        direction = "down";
                        j--;
                        content--;
                        continue;
                    }
                }
                if (direction.equals("down")) {
                    if (x + 1 < N && arr[x + 1][y] == 0) {
                        ++x;
                    } else {
                        direction = "left";
                        j--;
                        content--;
                        continue;
                    }
                }
                if (direction.equals("left")) {
                    if (y - 1 >= 0 && arr[x][y - 1] == 0) {
                        --y;
                    } else {
                        direction = "up";
                        j--;
                        content--;
                        continue;
                    }
                }
                if (direction.equals("up")) {
                    if (x - 1 >= 0 && arr[x - 1][y] == 0) {
                        --x;
                    } else {
                        direction = "right";
                        j--;
                        content--;
                        continue;
                    }
                }
                arr[x][y] = content;
            }
            bw.append("#").append(String.valueOf(i)).append("\n");
            for (int j = 0; j < N; j++) {
                bw.append(Arrays.toString(arr[j]).replaceAll(",", "").replace('[', ' ').replace(']', ' ').trim()).append("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
