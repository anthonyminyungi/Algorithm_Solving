package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;


//내 풀이가 뭔가 의심스러운 문제...
public class PermuCycle_10451 {
    private static int[][] cy;
    private static boolean[] cs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cy = new int[2][N + 1];
            cs = new boolean[N + 1];
            Arrays.fill(cs, false);
            String[] a = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                cy[0][i] = i;
                cy[1][i] = Integer.parseInt(a[i - 1]);
            }
            int total = 0;
            for (int i = 1; i <= N; i++) {
                total += cycles(i);
            }
            bw.append(total + "\n");
        }

        bw.flush();
    }

    private static int cycles(int index) {
        int res = 0;
        int it = index;
        if (cs[index])
            return 0;
        else {
            cs[index] = true;
            while (true) {
                if (cy[1][it] == index) {
                    res = 1;
                    break;
                }
                it = cy[1][it];
                cs[it] = true;
            }
        }
        return res;
    }

}
