package com.algorithms.BOJ.JAVA;

import java.io.*;

public class IOIOI_5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int ans = 0, repeat = 0;

        for (int i = 1; i < m - 1; i++) {
            if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                repeat++;
                if (repeat == n) {
                    repeat--;
                    ans++;
                }
                i++;
            } else repeat = 0;
        }
        System.out.println(ans);
    }
}
