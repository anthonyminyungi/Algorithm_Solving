package com.algorithms.BOJ.JAVA;

import java.io.*;

public class IBMminus1_6321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] comp = br.readLine().toCharArray();
            for (int j = 0; j < comp.length; j++) {
                if (comp[j] < 90) {
                    comp[j] = (char) (comp[j] + 1);
                } else {
                    comp[j] = 'A';
                }
            }

            bw.append("String #" + (i + 1) + "\n");
            if (i < T - 1)
                bw.append(String.valueOf(comp) + "\n\n");
            else
                bw.append(String.valueOf(comp));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
