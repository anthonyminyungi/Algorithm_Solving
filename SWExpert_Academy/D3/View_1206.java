package com.java.SWExpert_Academy.D3;

import java.io.*;
import java.util.Arrays;

public class View_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        for (int i = 1; i <= T; i++) {
            int len = Integer.parseInt(br.readLine());
            String[] apt = br.readLine().split(" ");
            int sum = 0;
            int[] comp = new int[4];
            for (int j = 2; j < len - 2; j++) {
                int cur = Integer.parseInt(apt[j]);
                comp[0] = Integer.parseInt(apt[j - 2]);
                comp[1] = Integer.parseInt(apt[j - 1]);
                comp[2] = Integer.parseInt(apt[j + 1]);
                comp[3] = Integer.parseInt(apt[j + 2]);
                Arrays.sort(comp);
                if (comp[3] < cur)
                    sum += (cur - comp[3]);
            }
            bw.append("#").append(String.valueOf(i)).append(" ").append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
