package com.algorithms.BOJ.JAVA;

import java.io.*;

public class FCFS_10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");

        int n = Integer.parseInt(a[0]);
        int T = Integer.parseInt(a[1]);

        String[] b = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(b[i]);
            T -= k;
            if (T > 0)
                cnt++;
            else
                continue;
        }
        bw.append(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
