package com.java.SWExpert_Academy.D1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddingOdd_2072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int j = 1; j <= T; j++) {
            String[] in = br.readLine().split(" ");
            int sum = 0;
            for (int i = 0; i < in.length; i++) {
                int n = Integer.parseInt(in[i]);
                if (n % 2 != 0)
                    sum += n;
            }
            bw.append("#").append(String.valueOf(j)).append(" ").append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
