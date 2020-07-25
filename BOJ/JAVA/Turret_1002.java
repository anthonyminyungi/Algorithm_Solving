package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.StringTokenizer;

public class Turret_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());
            double hi, lo;
            if (r1 > r2) {
                hi = r1;
                lo = r2;
            } else if (r1 < r2) {
                hi = r2;
                lo = r1;
            } else
                hi = lo = r2;

            double d = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));

            if (hi + lo < d || hi - lo > d)
                cnt = 0;
            else if (x1 == x2 && y1 == y2 && hi - lo == 0)
                cnt = -1;
            else if (hi + lo == d || hi - lo == d)
                cnt = 1;
            else if (hi + lo > d && hi - lo < d)
                cnt = 2;

            bw.append(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
