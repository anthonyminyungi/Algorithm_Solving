package com.java;

import java.io.*;

public class StoneGame_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] turn = {"SK", "CY"};

        int i = -1;
        while (N > 0) {
            i++;
            if (i > 1)
                i = 0;
            if (N >= 3)
                N -= 1 | 3;
            else
                N -= 1;
        }
        bw.write(turn[i]);
        bw.flush();
        bw.close();
        br.close();
    }
}
