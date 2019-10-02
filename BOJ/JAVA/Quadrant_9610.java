package com.java.BOJ.JAVA;

import java.io.*;

public class Quadrant_9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int axis = 0;
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] a = br.readLine().split(" ");

            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);

            if (x == 0 || y == 0)
                axis++;

            if (x > 0 && y > 0)
                q1++;
            else if (x < 0 && y > 0)
                q2++;
            else if (x < 0 && y < 0)
                q3++;
            else if (x > 0 && y < 0)
                q4++;

        }
        bw.write("Q1: " + q1 + "\n");
        bw.write("Q2: " + q2 + "\n");
        bw.write("Q3: " + q3 + "\n");
        bw.write("Q4: " + q4 + "\n");
        bw.write("AXIS: " + axis);
        bw.flush();
    }

}
