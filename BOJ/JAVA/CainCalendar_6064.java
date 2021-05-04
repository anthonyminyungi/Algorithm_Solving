package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class CainCalendar_6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] mnxy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = mnxy[0], n = mnxy[1], x = mnxy[2], y = mnxy[3];
            int max = Math.max(n, m), min = Math.min(n, m);
            int loop = min / gcd(max, min);

            if (m == max) y %= n;
            else x %= m;

            int xyMax = m == max ? x : y, xyMin = m == max ? y : x;

            int ans = 0, i = 0;
            for (; i < loop; i++) {
                ans = i * max + (xyMax);
                if (ans % min == xyMin) break;
            }
            bw.append(String.valueOf(i == loop ? -1 : ans)).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
