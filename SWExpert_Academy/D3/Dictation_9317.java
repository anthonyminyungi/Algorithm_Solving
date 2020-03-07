package com.java.SWExpert_Academy.D3;

import java.io.*;

public class Dictation_9317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String dict = br.readLine();
            int right = 0;
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == dict.charAt(j))
                    right++;
            }
            bw.append("#").append(String.valueOf(i)).append(" ").append(String.valueOf(right)).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
