package com.java.BOJ.JAVA;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CalcualteE_6376 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.append("n e\n");
        bw.append("- -----------\n");
        double e = 0;
        for (int i = 0; i <= 9; i++) {
            e += 1 / Facto(i);
            if (i <= 1) {
                bw.append(i + " " + (int) e + "\n");
            } else if (i == 2)
                bw.append(i + " " + e + "\n");
            else {
                bw.append(i + " " + String.format("%.9f", e) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static double Facto(int a) {
        if (a == 1 || a == 0)
            return 1;
        return a * Facto(a - 1);
    }
}