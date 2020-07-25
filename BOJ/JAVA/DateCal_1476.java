package com.algorithms.BOJ.JAVA;

import java.io.*;

public class DateCal_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");

        int E = Integer.parseInt(in[0]);
        int S = Integer.parseInt(in[1]);
        int M = Integer.parseInt(in[2]);

        int y = 1;
        int e1 = 1;
        int s1 = 1;
        int m1 = 1;
        while (true) {


            if (e1 == E && s1 == S && m1 == M)
                break;

            e1++;
            s1++;
            m1++;

            y++;
            if (e1 > 15)
                e1 = 1;
            if (s1 > 28)
                s1 = 1;
            if (m1 > 19)
                m1 = 1;
        }
        System.out.println(y);
    }
}
