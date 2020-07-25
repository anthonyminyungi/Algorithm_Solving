package com.algorithms.BOJ.JAVA;

import java.io.*;

public class StoneGame4_9658 {
    static int[] stone = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stone[0] = 0;
        stone[1] = 0;
        stone[2] = 1;
        stone[3] = 0;
        stone[4] = 1;
        stone();
        int a = Integer.parseInt(br.readLine());
        if (stone[a] == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }

    static void stone() {
        for (int i = 5; i <= 1000; i++) {
            if (stone[i - 1] + stone[i - 3] + stone[i - 4] == 3)
                stone[i] = 0;
            else
                stone[i] = 1;
        }
    }
}
