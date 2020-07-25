package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CuteOrNotCute_10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0)
                cnt0++;
            else if (a == 1)
                cnt1++;
        }
        if (cnt0 > cnt1)
            bw.append("Junhee is not cute!");
        else
            bw.append("Junhee is cute!");
        bw.flush();
        bw.close();
        br.close();
    }
}
