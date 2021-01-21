package com.algorithms.BOJ.JAVA;

import java.io.*;

public class DistributedProcess_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int pc = 10;

        while (t-- > 0) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            int ans = a % pc;
            for (int i = 1; i < b; i++) {
                ans = (ans * a) % pc;
            }
            bw.append(String.valueOf(ans == 0 ? 10 : ans)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
