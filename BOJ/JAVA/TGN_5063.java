package com.java.BOJ.JAVA;

import java.io.*;

public class TGN_5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");

            int r = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            int c = Integer.parseInt(a[2]);

            if (e - c > r)
                bw.append("advertise\n");
            else if (e - c == r)
                bw.append("does not matter\n");
            else
                bw.append("do not advertise\n");
        }

        bw.flush();

    }
}
