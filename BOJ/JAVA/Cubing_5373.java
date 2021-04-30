package com.algorithms.BOJ.JAVA;

import java.io.*;

// 복잡...


//1
//10
//L- U- L+ U- L- U- U- L+ U+ U+


public class Cubing_5373 {
    static char[][] up = {
            {'w', 'w', 'w'},
            {'w', 'w', 'w'},
            {'w', 'w', 'w'}
    };
    static char[][] front = {
            {'r', 'r', 'r'},
            {'r', 'r', 'r'},
            {'r', 'r', 'r'}
    };
    static char[][] down = {
            {'y', 'y', 'y'},
            {'y', 'y', 'y'},
            {'y', 'y', 'y'}
    };
    static char[][] back = {
            {'o', 'o', 'o'},
            {'o', 'o', 'o'},
            {'o', 'o', 'o'}
    };
    static char[][] left = {
            {'g', 'g', 'g'},
            {'g', 'g', 'g'},
            {'g', 'g', 'g'}
    };
    static char[][] right = {
            {'b', 'b', 'b'},
            {'b', 'b', 'b'},
            {'b', 'b', 'b'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] commands = br.readLine().split(" ");
            for (String command : commands) {
                char face = command.charAt(0);
                char dir = command.charAt(1);

                rotateEdge(face, dir);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(up[i][j]);
                }
                sb.append("\n");
            }
            bw.append(sb.toString());
            up = new char[][]{
                    {'w', 'w', 'w'},
                    {'w', 'w', 'w'},
                    {'w', 'w', 'w'}
            };
            front = new char[][]{
                    {'r', 'r', 'r'},
                    {'r', 'r', 'r'},
                    {'r', 'r', 'r'}
            };
            down = new char[][]{
                    {'y', 'y', 'y'},
                    {'y', 'y', 'y'},
                    {'y', 'y', 'y'}
            };
            back = new char[][]{
                    {'o', 'o', 'o'},
                    {'o', 'o', 'o'},
                    {'o', 'o', 'o'}
            };
            left = new char[][]{
                    {'g', 'g', 'g'},
                    {'g', 'g', 'g'},
                    {'g', 'g', 'g'}
            };
            right = new char[][]{
                    {'b', 'b', 'b'},
                    {'b', 'b', 'b'},
                    {'b', 'b', 'b'}
            };
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void rotateFace(char[][] f, char d) {
        char[][] temp = new char[3][3];
        int k = 0;
        for (char[] line : f) System.arraycopy(line, 0, temp[k++], 0, 3);

        if (d == '+') {
            for (int i = 0; i < 3; i++) f[0][i] = temp[2 - i][0];
            for (int i = 0; i < 3; i++) f[2][i] = temp[2 - i][2];
            for (int i = 0; i < 3; i++) f[1][i] = temp[2 - i][1];
        } else {
            for (int i = 0; i < 3; i++) f[0][i] = temp[i][2];
            for (int i = 0; i < 3; i++) f[2][i] = temp[i][0];
            for (int i = 0; i < 3; i++) f[1][i] = temp[i][1];
        }
    }

    static void rotateEdge(char f, char d) {
        char[] tmp = new char[3];
        switch (f) {
            case 'U':
                System.arraycopy(front[0], 0, tmp, 0, 3);
                rotateFace(up, d);
                if (d == '+') {
                    front[0] = right[0];
                    right[0] = back[0];
                    back[0] = left[0];
                    left[0] = tmp;
                } else {
                    front[0] = left[0];
                    left[0] = back[0];
                    back[0] = right[0];
                    right[0] = tmp;
                }
                break;
            case 'D':
                System.arraycopy(front[2], 0, tmp, 0, 3);
                rotateFace(down, d);
                if (d == '+') {
                    front[2] = left[2];
                    left[2] = back[2];
                    back[2] = right[2];
                    right[2] = tmp;
                } else {
                    front[2] = right[2];
                    right[2] = back[2];
                    back[2] = left[2];
                    left[2] = tmp;
                }
                break;
            case 'F':
                System.arraycopy(up[2], 0, tmp, 0, 3);
                rotateFace(front, d);
                if (d == '+') {
                    for (int i = 0; i < 3; i++) up[2][i] = left[2 - i][2];
                    for (int i = 0; i < 3; i++) left[i][2] = down[0][i];
                    for (int i = 0; i < 3; i++) down[0][i] = right[2 - i][0];
                    for (int i = 0; i < 3; i++) right[i][0] = tmp[i];
                } else {
                    for (int i = 0; i < 3; i++) up[2][i] = right[i][0];
                    for (int i = 0; i < 3; i++) right[i][0] = down[0][2 - i];
                    for (int i = 0; i < 3; i++) down[0][i] = left[i][2];
                    for (int i = 0; i < 3; i++) left[i][2] = tmp[2 - i];
                }
                break;
            case 'B':
                System.arraycopy(down[2], 0, tmp, 0, 3);
                rotateFace(back, d);
                if (d == '+') {
                    for (int i = 0; i < 3; i++) down[2][i] = left[i][0];
                    for (int i = 0; i < 3; i++) left[i][0] = up[0][2 - i];
                    for (int i = 0; i < 3; i++) up[0][i] = right[i][2];
                    for (int i = 0; i < 3; i++) right[i][2] = tmp[2 - i];
                } else {
                    for (int i = 0; i < 3; i++) down[2][i] = right[2 - i][2];
                    for (int i = 0; i < 3; i++) right[i][2] = up[0][i];
                    for (int i = 0; i < 3; i++) up[0][i] = left[2 - i][0];
                    for (int i = 0; i < 3; i++) left[i][0] = tmp[i];
                }
                break;
            case 'L':
                tmp = new char[]{back[0][2], back[1][2], back[2][2]};
                rotateFace(left, d);
                if (d == '+') {
                    for (int i = 0; i < 3; i++) back[i][2] = down[2 - i][0];
                    for (int i = 0; i < 3; i++) down[i][0] = front[i][0];
                    for (int i = 0; i < 3; i++) front[i][0] = up[i][0];
                    for (int i = 0; i < 3; i++) up[i][0] = tmp[2 - i];
                } else {
                    for (int i = 0; i < 3; i++) back[i][2] = up[2 - i][0];
                    for (int i = 0; i < 3; i++) up[i][0] = front[i][0];
                    for (int i = 0; i < 3; i++) front[i][0] = down[i][0];
                    for (int i = 0; i < 3; i++) down[i][0] = tmp[2 - i];
                }
                break;
            case 'R':
                tmp = new char[]{back[0][0], back[1][0], back[2][0]};
                rotateFace(right, d);
                if (d == '+') {
                    for (int i = 0; i < 3; i++) back[i][0] = up[2 - i][2];
                    for (int i = 0; i < 3; i++) up[i][2] = front[i][2];
                    for (int i = 0; i < 3; i++) front[i][2] = down[i][2];
                    for (int i = 0; i < 3; i++) down[i][2] = tmp[2 - i];
                } else {
                    for (int i = 0; i < 3; i++) back[i][0] = down[2 - i][2];
                    for (int i = 0; i < 3; i++) down[i][2] = front[i][2];
                    for (int i = 0; i < 3; i++) front[i][2] = up[i][2];
                    for (int i = 0; i < 3; i++) up[i][2] = tmp[2 - i];
                }
                break;
        }
    }
}
