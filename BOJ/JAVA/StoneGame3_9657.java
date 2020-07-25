package com.algorithms.BOJ.JAVA;

import java.io.*;

public class StoneGame3_9657 {
    static int[] stone = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stone[0] = 0;
        stone[1] = 1;
        stone[2] = 0;
        stone[3] = 1;
        stone[4] = 1;
        stone();
        int a = Integer.parseInt(br.readLine());
        if (stone[a] == 1)
            System.out.println("CY");
        else
            System.out.println("SK");
    }

    static void stone() {
        for (int i = 5; i <= 1000; i++) {
            if (stone[i - 1] + stone[i - 3] + stone[i - 4] < 3)
                stone[i] = 1;
            else
                stone[i] = 0;
        }
    }
}
