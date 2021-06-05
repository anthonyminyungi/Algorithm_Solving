package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Bridge_1010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(combCase(m, n))).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int combCase(int n, int r) {
        long up = 1, down = 1;
        if (r > n / 2) {
            for (int i = n; i > r; i--) up *= i;
            for (int i = (n - r); i > 1; i--) down *= i;
        } else {
            for (int i = n; i > (n - r); i--) up *= i;
            for (int i = r; i > 1; i--) down *= i;
        }
        return (int) (up / down);
    }
}
