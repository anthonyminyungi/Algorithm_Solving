package com.java.BOJ.JAVA;

import java.io.*;

public class SurroundedByFan_14581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = ":" + br.readLine() + ":";

        String fan = ":fan:";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.print(id);
                } else
                    System.out.print(fan);
            }
            System.out.println();
        }

    }
}
