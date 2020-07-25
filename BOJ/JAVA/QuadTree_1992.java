package com.algorithms.BOJ.JAVA;

import java.io.*;

public class QuadTree_1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] Quad = new char[N][N];
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            Quad[i] = a.toCharArray();
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(Quad[i]));
//        }
        br.close();
        QTree(bw, Quad, N);

        bw.flush();
        bw.close();
    }

    static void QTree(BufferedWriter writer, char[][] arr, int length) throws IOException {
        int init = Integer.parseInt(String.valueOf(arr[0][0]));
        if (length == 1) {
            writer.append(init + "");
            return;
        }
        boolean isCont = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (Integer.parseInt(String.valueOf(arr[i][j])) != init) {
                    isCont = false;
                    break;
                }
            }
            if (!isCont)
                break;
        }
        if (!isCont) {
            writer.append("(");

            char[][] temp = new char[length / 2][length / 2];
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            QTree(writer, temp, length / 2);
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    temp[i][j] = arr[i][j + length / 2];
                }
            }
            QTree(writer, temp, length / 2);
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    temp[i][j] = arr[i + length / 2][j];
                }
            }
            QTree(writer, temp, length / 2);
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length / 2; j++) {
                    temp[i][j] = arr[i + length / 2][j + length / 2];
                }
            }
            QTree(writer, temp, length / 2);
            writer.append(")");

        } else {
            writer.append(init + "");
        }

    }
}
