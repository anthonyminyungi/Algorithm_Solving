package com.java.BOJ.JAVA;

import java.io.*;
import java.util.StringTokenizer;

public class NewEmployee_1946_OtherSolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int standard = rank[1];
            int recruit = 1;
            for (int i = 2; i <= N; i++) {
                if (standard > rank[i]) {
                    standard = rank[i];
                    recruit++;
                }
            }
            bw.write(recruit + "\n");
        }
        bw.flush();
    }
}
